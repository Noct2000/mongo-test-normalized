package com.example.mongotestnormalized.mapper;

import com.example.mongotestnormalized.model.Subject;
import com.example.mongotestnormalized.model.dto.SubjectCreateRequestDto;
import com.example.mongotestnormalized.model.dto.SubjectResponseDto;
import com.example.mongotestnormalized.model.dto.SubjectUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper {
    public Subject toModel(SubjectCreateRequestDto subjectCreateRequestDto) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectCreateRequestDto.getSubjectName());
        subject.setMarkObtained(subjectCreateRequestDto.getMarkObtained());
        return subject;
    }

    public Subject toModel(SubjectUpdateRequestDto subjectUpdateRequestDto) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectUpdateRequestDto.getSubjectName());
        subject.setMarkObtained(subjectUpdateRequestDto.getMarkObtained());
        subject.setId(subjectUpdateRequestDto.getId());
        return subject;
    }

    public SubjectResponseDto toResponse(Subject subject) {
        SubjectResponseDto subjectResponseDto = new SubjectResponseDto();
        subjectResponseDto.setSubjectName(subject.getSubjectName());
        subjectResponseDto.setMarkObtained(subject.getMarkObtained());
        subjectResponseDto.setId(subject.getId());
        return subjectResponseDto;
    }
}
