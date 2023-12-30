package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubjectUpdateRequestDto {
    private String id;
    private String subjectName;
    private Integer markObtained;
}
