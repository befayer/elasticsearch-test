package com.example.elasticsearch.repositories;

import com.example.elasticsearch.entities.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BankRepository extends CrudRepository<Bank, String> {
    Optional<Bank> findBankByBankCity(String city);
}
