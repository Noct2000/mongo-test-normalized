package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentCreateRequestDto {
    private String name;
    private String email;
    private String departmentId;
    private List<String> subjectIds;
}
