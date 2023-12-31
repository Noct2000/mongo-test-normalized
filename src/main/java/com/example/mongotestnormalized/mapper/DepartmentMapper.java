package com.example.mongotestnormalized.mapper;

import com.example.mongotestnormalized.model.Department;
import com.example.mongotestnormalized.model.dto.DepartmentCreateRequestDto;
import com.example.mongotestnormalized.model.dto.DepartmentResponseDto;
import com.example.mongotestnormalized.model.dto.DepartmentUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public Department toModel(DepartmentCreateRequestDto departmentCreateRequestDto) {
        Department department = new Department();
        department.setDepartmentName(departmentCreateRequestDto.getDepartmentName());
        department.setLocation(departmentCreateRequestDto.getLocation());
        return department;
    }

    public Department toModel(DepartmentUpdateRequestDto departmentUpdateRequestDto) {
        Department department = new Department();
        department.setDepartmentName(departmentUpdateRequestDto.getDepartmentName());
        department.setLocation(departmentUpdateRequestDto.getLocation());
        department.setId(departmentUpdateRequestDto.getId());
        return department;
    }

    public DepartmentResponseDto toResponse(Department department) {
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        departmentResponseDto.setDepartmentName(department.getDepartmentName());
        departmentResponseDto.setLocation(department.getLocation());
        departmentResponseDto.setId(department.getId());
        return departmentResponseDto;
    }
}
