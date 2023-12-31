package com.example.mongotestnormalized.controller;

import com.example.mongotestnormalized.mapper.StudentMapper;
import com.example.mongotestnormalized.model.Student;
import com.example.mongotestnormalized.model.dto.StudentCreateRequestDto;
import com.example.mongotestnormalized.model.dto.StudentResponseDto;
import com.example.mongotestnormalized.model.dto.StudentUpdateRequestDto;
import com.example.mongotestnormalized.service.StudentService;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentResponseDto create(
            @RequestBody
            StudentCreateRequestDto studentCreateRequestDto
    ) {
        Student student = studentService.save(studentMapper.toModel(studentCreateRequestDto));
        return studentMapper.toResponse(student);
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.getAll().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getById(@PathVariable String id) {
        return studentMapper.toResponse(studentService.getById(id));
    }

    @PutMapping
    public StudentResponseDto update(
            @RequestBody
            StudentUpdateRequestDto studentUpdateRequestDto
    ) {
        Student student = studentService.update(studentMapper.toModel(studentUpdateRequestDto));
        return studentMapper.toResponse(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        boolean isDeleted = studentService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
