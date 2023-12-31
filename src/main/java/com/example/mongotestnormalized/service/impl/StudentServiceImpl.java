package com.example.mongotestnormalized.service.impl;

import com.example.mongotestnormalized.model.Student;
import com.example.mongotestnormalized.repository.StudentRepository;
import com.example.mongotestnormalized.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No student with id: " + id));
    }

    @Override
    public Student update(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(String id) {
        boolean isExists = studentRepository.existsById(id);
        if (isExists) {
            studentRepository.deleteById(id);
        }
        return isExists;
    }
}
