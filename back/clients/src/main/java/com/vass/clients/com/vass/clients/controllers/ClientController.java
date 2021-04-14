package com.vass.clients.com.vass.clients.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;


    @PostMapping()
    public ClientDto saveClient(@RequestBody ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @GetMapping()
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/search")
    public List<ClientDto> searchClients(@RequestParam Map<String, String> params) {
        return clientService.searchClients(getFiltersSearchClientsDto(params));
    }

    private ClientDto getFiltersSearchClientsDto(@RequestParam Map<String, String> params) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(params, ClientDto.class);
    }




}
