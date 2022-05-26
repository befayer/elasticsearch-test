package com.example.elasticsearch.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Currency {
    @Id
    private UUID id;
    private String nameCurrency;

    public Currency(UUID id, String nameCurrency) {
        this.id = id;
        this.nameCurrency = nameCurrency;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }
}
