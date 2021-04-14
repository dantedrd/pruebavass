package com.vass.clients.com.vass.clients.persistence;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.mapper.ClientMapper;
import com.vass.clients.com.vass.clients.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class ClientAdapterRepository {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public ClientDto saveClient(ClientDto clientDto){
        return clientMapper.toDTO(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    public List<ClientDto> getClients(){
        return clientRepository
                .findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ClientDto> searchClient(ClientDto clientDto){
        return clientRepository
                .findAll(this.getClientByParam(clientDto))
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Specification<Client> getClientByParam(ClientDto clientDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(Objects.nonNull(clientDto.getSharedKey())){
                predicates.add(criteriaBuilder.like(root.get("sharedKey"),"%"+clientDto.getSharedKey()+"%"));
            }
            if(Objects.nonNull(clientDto.getBussinessId())){
                predicates.add(criteriaBuilder.like(root.get("bussinessId"),"%"+clientDto.getBussinessId()+"%"));
            }
            if(Objects.nonNull(clientDto.getEmail())){
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("email"),"%"+clientDto.getEmail()+"%")));
            }
            if(Objects.nonNull(clientDto.getPhone())){
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("phone"),"%"+clientDto.getPhone()+"%")));
            }
            if(Objects.nonNull(clientDto.getStartDate())){
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("startDate"),clientDto.getStartDate())));
            }
            if(Objects.nonNull(clientDto.getEndDate())){
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("endDate"),clientDto.getEndDate())));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }




}
