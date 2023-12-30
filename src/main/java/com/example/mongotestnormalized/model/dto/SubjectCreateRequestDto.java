package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectCreateRequestDto {
    private String subjectName;
    private Integer markObtained;
}
