package com.vass.clients.com.vass.clients.services;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.persistence.ClientAdapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientAdapterRepository clientAdapterRepository;

    @Override
    public ClientDto saveClient(ClientDto clientDto){
        return clientAdapterRepository.saveClient(clientDto);
    }

    @Override
    public List<ClientDto> getClients(){
        return clientAdapterRepository.getClients();
    }

    @Override
    public List<ClientDto> searchClients(ClientDto clientDto) {
        return clientAdapterRepository.searchClient(clientDto);
    }

}
