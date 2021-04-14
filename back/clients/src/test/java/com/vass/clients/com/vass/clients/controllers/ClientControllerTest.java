package com.vass.clients.com.vass.clients.controllers;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.models.Client;
import com.vass.clients.com.vass.clients.services.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {
    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @Test
    public void deveriaConsultarClientes() {
        List<ClientDto> clientes=new ArrayList<>();
        ClientDto client=new ClientDto();
        client.setBussinessId("Darwin Rosero");
        clientes.add(client);

        ClientDto clientDto=new ClientDto();
        clientDto.setBussinessId("Darwin Rosero");

        Mockito.when(clientService.getClients()).thenReturn(clientes);
        List<ClientDto> clients=clientController.getClients();
        assertEquals(clients.get(0).getBussinessId(),"Darwin Rosero");
    }

    @Test
    public void deveriaGuardarCliente() {
        ClientDto client=new ClientDto();
        client.setBussinessId("Darwin Rosero");
        Mockito.when(clientService.saveClient(Mockito.any(ClientDto.class))).thenReturn(client);
        ClientDto clienteResponse=clientController.saveClient(new ClientDto());
        assertEquals(clienteResponse.getBussinessId(),"Darwin Rosero");
    }

}