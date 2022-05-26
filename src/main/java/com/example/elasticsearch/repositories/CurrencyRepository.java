package com.example.elasticsearch.repositories;

import com.example.elasticsearch.entities.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CurrencyRepository extends CrudRepository<Currency, UUID> {
}
