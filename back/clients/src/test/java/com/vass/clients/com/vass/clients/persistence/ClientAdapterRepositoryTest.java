package com.vass.clients.com.vass.clients.persistence;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.mapper.ClientMapper;
import com.vass.clients.com.vass.clients.models.Client;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientAdapterRepositoryTest {

    @Mock
    private ClientRepository repository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    ClientAdapterRepository clientAdapterRepository;

    @Test
    public void deveriaConsultarClientes() {
        List<Client> clientes=new ArrayList<>();
        Client client=new Client();
        client.setBussinessId("Darwin Rosero");
        clientes.add(client);

        ClientDto clientDto=new ClientDto();
        clientDto.setBussinessId("Darwin Rosero");

        Mockito.when(repository.findAll()).thenReturn(clientes);
        Mockito.when(clientMapper.toDTO(Mockito.any(Client.class))).thenReturn(clientDto);
        List<ClientDto> clients=clientAdapterRepository.getClients();
        assertEquals(clients.get(0).getBussinessId(),"Darwin Rosero");
    }

    @Test
    public void deveriaConsultarClientesPorBusqueda() {
        List<Client> clientes=new ArrayList<>();
        Client client=new Client();
        client.setBussinessId("Darwin Rosero");
        clientes.add(client);

        ClientDto clientDto=new ClientDto();
        clientDto.setBussinessId("Darwin Rosero");

        Mockito.when(repository.findAll(Mockito.any(Specification.class))).thenReturn(clientes);
        Mockito.when(clientMapper.toDTO(Mockito.any(Client.class))).thenReturn(clientDto);
        List<ClientDto> clients=clientAdapterRepository.searchClient(new ClientDto());
        assertEquals(clients.get(0).getBussinessId(),"Darwin Rosero");
    }
}