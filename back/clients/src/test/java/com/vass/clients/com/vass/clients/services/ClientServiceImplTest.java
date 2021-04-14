package com.vass.clients.com.vass.clients.services;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.models.Client;
import com.vass.clients.com.vass.clients.persistence.ClientAdapterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    @Mock
    ClientAdapterRepository clientAdapterRepository;

    @InjectMocks
    ClientServiceImpl clientService;

    @Test
    public void deveriaConsultarClientes() {
        List<ClientDto> clientes=new ArrayList<>();
        ClientDto client=new ClientDto();
        client.setBussinessId("Darwin Rosero");
        clientes.add(client);
        Mockito.when(clientAdapterRepository.getClients()).thenReturn(clientes);
        List<ClientDto> clientesResponse=clientService.getClients();
        assertEquals(clientesResponse.get(0).getBussinessId(),"Darwin Rosero");
    }

    @Test
    public void deveriaConsultarClientesPorBusqueda() {
        List<ClientDto> clientes=new ArrayList<>();
        ClientDto client=new ClientDto();
        client.setBussinessId("Darwin Rosero");
        clientes.add(client);
        Mockito.when(clientAdapterRepository.searchClient(Mockito.any(ClientDto.class))).thenReturn(clientes);
        List<ClientDto> clientesResponse=clientService.searchClients(client);
        assertEquals(clientesResponse.get(0).getBussinessId(),"Darwin Rosero");
    }

    @Test
    public void deveriaGuardarCliente() {
        ClientDto client=new ClientDto();
        client.setBussinessId("Darwin Rosero");
        Mockito.when(clientAdapterRepository.saveClient(Mockito.any(ClientDto.class))).thenReturn(client);
        ClientDto clienteResponse=clientService.saveClient(new ClientDto());
        assertEquals(clienteResponse.getBussinessId(),"Darwin Rosero");
    }

}