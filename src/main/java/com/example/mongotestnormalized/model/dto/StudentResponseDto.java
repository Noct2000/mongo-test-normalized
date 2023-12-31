package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentResponseDto {
    private String id;
    private String name;
    private String email;
    private DepartmentResponseDto department;
    private List<SubjectResponseDto> subjects;
}
