package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class StudentUpdateRequestDto {
    private String id;
    private String name;
    private String email;
    private String departmentId;
    private List<String> subjectIds;
}
