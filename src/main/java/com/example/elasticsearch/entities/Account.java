package com.example.elasticsearch.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "index_account")
public class Account {
    @Id
    private String id;
    @Field(type = FieldType.Double)
    private double balance;
    @Field(type = FieldType.Object)
    private Bank bank;
    @Field(type = FieldType.Object)
    private Currency currency;
    @Field(type = FieldType.Object)
    private Client client;


    public Account(String id, double balance, Bank bank, Currency currency, Client client) {
        this.id = id;
        this.balance = balance;
        this.bank = bank;
        this.currency = currency;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
