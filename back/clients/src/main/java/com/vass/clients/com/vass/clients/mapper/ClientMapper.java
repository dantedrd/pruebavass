package com.vass.clients.com.vass.clients.mapper;

import com.vass.clients.com.vass.clients.dtos.ClientDto;
import com.vass.clients.com.vass.clients.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {
    public abstract ClientDto toDTO(Client client);
    public abstract Client toEntity(ClientDto clientDto);
}
