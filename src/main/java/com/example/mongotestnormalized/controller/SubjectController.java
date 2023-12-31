package com.example.mongotestnormalized.controller;

import com.example.mongotestnormalized.mapper.SubjectMapper;
import com.example.mongotestnormalized.model.Subject;
import com.example.mongotestnormalized.model.dto.SubjectCreateRequestDto;
import com.example.mongotestnormalized.model.dto.SubjectResponseDto;
import com.example.mongotestnormalized.model.dto.SubjectUpdateRequestDto;
import com.example.mongotestnormalized.service.SubjectService;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Operation(
            summary = "Create new subject",
            description = "Create new subject by given json"
    )
    @PostMapping
    public SubjectResponseDto create(
            @RequestBody
            SubjectCreateRequestDto subjectCreateRequestDto
    ) {
        Subject subject = subjectService.save(subjectMapper.toModel(subjectCreateRequestDto));
        return subjectMapper.toResponse(subject);
    }

    @Operation(
            summary = "Get all subjects",
            description = "Get all subjects"
    )
    @GetMapping
    public List<SubjectResponseDto> getAll() {
        return subjectService.getAll()
                .stream()
                .map(subjectMapper::toResponse)
                .toList();
    }

    @Operation(
            summary = "Get subject by id",
            description = "Get subject by id in path variable"
    )
    @GetMapping("/{id}")
    public SubjectResponseDto getById(@PathVariable String id) {
        return subjectMapper.toResponse(subjectService.getById(id));
    }

    @Operation(
            summary = "Update subject",
            description = "Update whole subject document by given json"
    )
    @PutMapping
    public SubjectResponseDto update(@RequestBody SubjectUpdateRequestDto subjectUpdateRequestDto) {
        Subject subject = subjectService.update(subjectMapper.toModel(subjectUpdateRequestDto));
        return subjectMapper.toResponse(subject);
    }

    @Operation(
            summary = "Delete subject",
            description = "Delete subject by given id in path variable"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(subjectService.deleteById(id));
    }
}
