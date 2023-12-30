package com.example.mongotestnormalized.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "subject")
public class Subject {
    @Id
    private String id;
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "mark_obtained")
    private Integer markObtained;
}
