package com.vass.clients.com.vass.clients.services;

import com.vass.clients.com.vass.clients.dtos.ClientDto;

import java.util.List;

public interface ClientService {
     ClientDto saveClient(ClientDto clientDto);
     List<ClientDto> getClients();
     List<ClientDto> searchClients(ClientDto clientDto);
}
