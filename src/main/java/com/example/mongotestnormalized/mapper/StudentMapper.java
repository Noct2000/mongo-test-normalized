package com.example.mongotestnormalized.mapper;

import com.example.mongotestnormalized.model.Student;
import com.example.mongotestnormalized.model.dto.StudentCreateRequestDto;
import com.example.mongotestnormalized.model.dto.StudentResponseDto;
import com.example.mongotestnormalized.model.dto.StudentUpdateRequestDto;
import com.example.mongotestnormalized.service.DepartmentService;
import com.example.mongotestnormalized.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final DepartmentService departmentService;
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;
    private final DepartmentMapper departmentMapper;

    public Student toModel(StudentCreateRequestDto studentCreateRequestDto) {
        Student student = new Student();
        student.setEmail(studentCreateRequestDto.getEmail());
        student.setName(studentCreateRequestDto.getName());
        student.setDepartment(departmentService.getById(studentCreateRequestDto.getDepartmentId()));
        student.setSubjects(subjectService.getAllByIdIn(studentCreateRequestDto.getSubjectIds()));
        return student;
    }

    public Student toModel(StudentUpdateRequestDto studentUpdateRequestDto) {
        Student student = new Student();
        student.setEmail(studentUpdateRequestDto.getEmail());
        student.setName(studentUpdateRequestDto.getName());
        student.setDepartment(departmentService.getById(studentUpdateRequestDto.getDepartmentId()));
        student.setSubjects(subjectService.getAllByIdIn(studentUpdateRequestDto.getSubjectIds()));
        student.setId(studentUpdateRequestDto.getId());
        return student;
    }

    public StudentResponseDto toResponse(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setDepartment(departmentMapper.toResponse(student.getDepartment()));
        studentResponseDto.setName(student.getName());
        studentResponseDto.setSubjects(student.getSubjects().stream().map(subjectMapper::toResponse).toList());
        return studentResponseDto;
    }
}
