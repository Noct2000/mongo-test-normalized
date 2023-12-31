package com.example.mongotestnormalized.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentCreateRequestDto {
    private String departmentName;
    private String location;
}
