package com.example.mongotestnormalized.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "department")
public class Department {
    @Id
    private String id;
    @Field(name = "department_name")
    private String departmentName;
    private String location;
}
