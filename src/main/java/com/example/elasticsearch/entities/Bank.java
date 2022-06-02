package com.example.elasticsearch.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "index_bank")
public class Bank {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String bankName;
    @Field(type = FieldType.Text)
    private String bankCity;

    public Bank(String id,
                String bankName,
                String bankCity) {
        this.id = id;
        this.bankName = bankName;
        this.bankCity = bankCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }
}
