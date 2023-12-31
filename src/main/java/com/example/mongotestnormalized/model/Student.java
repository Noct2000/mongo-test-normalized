package com.example.mongotestnormalized.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Setter
@Getter
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    @DBRef(lazy = true)
    private Department department;
    @DBRef(lazy = true)
    private List<Subject> subjects;
}
