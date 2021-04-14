package com.vass.clients.com.vass.clients.persistence;

import com.vass.clients.com.vass.clients.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClientRepository extends JpaRepository<Client,Long>, JpaSpecificationExecutor<Client> {
}
