package com.example.mongotestnormalized.controller;

import com.example.mongotestnormalized.mapper.DepartmentMapper;
import com.example.mongotestnormalized.model.Department;
import com.example.mongotestnormalized.model.dto.DepartmentCreateRequestDto;
import com.example.mongotestnormalized.model.dto.DepartmentResponseDto;
import com.example.mongotestnormalized.model.dto.DepartmentUpdateRequestDto;
import com.example.mongotestnormalized.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @PostMapping
    public DepartmentResponseDto create(
            @RequestBody
            DepartmentCreateRequestDto departmentCreateRequestDto
    ) {
        Department department = departmentMapper.toModel(departmentCreateRequestDto);
        return departmentMapper.toResponse(departmentService.save(department));
    }

    @GetMapping
    public List<DepartmentResponseDto> getAll() {
        return departmentService.getAll().stream()
                .map(departmentMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto getById(@PathVariable String id) {
        return departmentMapper.toResponse(departmentService.getById(id));
    }

    @PutMapping
    public DepartmentResponseDto update(
            @RequestBody
            DepartmentUpdateRequestDto departmentUpdateRequestDto
    ) {
        Department department = departmentService
                .update(departmentMapper.toModel(departmentUpdateRequestDto));
        return departmentMapper.toResponse(department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        boolean isDeleted = departmentService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
