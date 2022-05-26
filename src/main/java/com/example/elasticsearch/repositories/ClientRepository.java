package com.example.elasticsearch.repositories;

import com.example.elasticsearch.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<Client, UUID> {
}
