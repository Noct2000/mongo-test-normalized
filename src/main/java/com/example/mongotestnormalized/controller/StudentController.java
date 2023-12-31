package com.example.mongotestnormalized.controller;

import com.example.mongotestnormalized.mapper.StudentMapper;
import com.example.mongotestnormalized.model.Student;
import com.example.mongotestnormalized.model.dto.StudentCreateRequestDto;
import com.example.mongotestnormalized.model.dto.StudentResponseDto;
import com.example.mongotestnormalized.model.dto.StudentUpdateRequestDto;
import com.example.mongotestnormalized.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Operation(
            summary = "Create new student",
            description = "Create new student by given json"
    )
    @PostMapping
    public StudentResponseDto create(
            @RequestBody
            StudentCreateRequestDto studentCreateRequestDto
    ) {
        Student student = studentService.save(studentMapper.toModel(studentCreateRequestDto));
        return studentMapper.toResponse(student);
    }

    @Operation(
            summary = "Get all students",
            description = "Get all students with pagination and sort. "
                    + "NOTE: sort must be formatted like field1,field2, ..."
    )
    @GetMapping
    public List<StudentResponseDto> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false) Optional<String> sort
    ) {
        return studentService.getAll().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get student by id",
            description = "Get student by id"
    )
    @GetMapping("/{id}")
    public StudentResponseDto getById(@PathVariable String id) {
        return studentMapper.toResponse(studentService.getById(id));
    }

    @Operation(
            summary = "Get all students by name",
            description = "Find all students by name"
    )
    @GetMapping("/findByName")
    public List<StudentResponseDto> getAllByName(@RequestParam String name) {
        return studentService.getAllByName(name).stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get all students by Name AND email",
            description = "Find all students by name AND email")
    @GetMapping("/findByNameAndEmail")
    public List<StudentResponseDto> getAllByNameAndEmail(
            @RequestParam String name,
            @RequestParam String email
    ) {
        return studentService.getAllByNameAndEmail(name, email).stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get all students by Name OR email",
            description = "Find all students by name OR email")
    @GetMapping("/findByNameOrEmail")
    public List<StudentResponseDto> getAllByNameOrEmail(
            @RequestParam String name,
            @RequestParam String email
    ) {
        return studentService.getAllByNameOrEmail(name, email).stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get all students by email part",
            description = "Find all students by email LIKE"
    )
    @GetMapping("/findByEmailLike")
    public List<StudentResponseDto> getAllByEmailLike(@RequestParam String email) {
        return studentService.getAllByEmailLike(email).stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get all students by name prefix",
            description = "Find all students by name STARTS WITH"
    )
    @GetMapping("/findByNameStartsWith")
    public List<StudentResponseDto> getAllByNameStartsWith(@RequestParam String name) {
        return studentService.getAllByNameStartsWith(name).stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Update student",
            description = "Update whole student by given json"
    )
    @PutMapping
    public StudentResponseDto update(
            @RequestBody
            StudentUpdateRequestDto studentUpdateRequestDto
    ) {
        Student student = studentService.update(studentMapper.toModel(studentUpdateRequestDto));
        return studentMapper.toResponse(student);
    }

    @Operation(
            summary = "Delete student by id",
            description = "Delete student by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        boolean isDeleted = studentService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
