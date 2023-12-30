package com.example.mongotestnormalized.service.impl;

import com.example.mongotestnormalized.model.Subject;
import com.example.mongotestnormalized.repository.SubjectRepository;
import com.example.mongotestnormalized.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(String id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No subjects with id: " + id));
    }

    @Override
    public Subject update(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(String id) {
        boolean isExists = subjectRepository.existsById(id);
        if (isExists) {
            subjectRepository.deleteById(id);
        }
        return isExists;
    }
}
