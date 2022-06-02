package com.example.elasticsearch.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Data
@Document(indexName = "index_client")
public class Client {
    @Id
    private UUID id;
    @Field(type = FieldType.Text)
    private String firstname;
    @Field(type = FieldType.Text)
    private String lastname;

    public Client(UUID id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
