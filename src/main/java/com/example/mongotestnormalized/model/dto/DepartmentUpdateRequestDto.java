package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentUpdateRequestDto {
    private String id;
    private String departmentName;
    private String location;
}
