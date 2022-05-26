package com.example.elasticsearch.repositories;

import com.example.elasticsearch.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String> {
}
