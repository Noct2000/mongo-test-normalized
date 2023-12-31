package com.example.mongotestnormalized.service.impl;

import com.example.mongotestnormalized.model.Student;
import com.example.mongotestnormalized.repository.StudentRepository;
import com.example.mongotestnormalized.service.DepartmentService;
import com.example.mongotestnormalized.service.StudentService;
import com.example.mongotestnormalized.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private static final String SORT_KEYS_DELIMITER = ",";
    private static final String NAME_STARTS_REGEX = "^%s";
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
    public List<Student> getAll(Integer page, Integer limit, Optional<String> sortKeys) {
        PageRequest pageRequest = sortKeys.isPresent()
                ? PageRequest.of(page, limit, Sort.by(sortKeys.get().split(SORT_KEYS_DELIMITER)))
                : PageRequest.of(page, limit);
        return studentRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<Student> getAllByName(String name) {
        return studentRepository.findAllByName(name);
    }

    @Override
    public List<Student> getAllByNameAndEmail(String name, String email) {
        return studentRepository.findAllByNameAndEmail(name, email);
    }

    @Override
    public List<Student> getAllByNameOrEmail(String name, String email) {
        return studentRepository.findAllByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllByEmailLike(String email) {
        return studentRepository.findAllByEmailLike(email);
    }

    @Override
    public List<Student> getAllByNameStartsWith(String name) {
        return studentRepository.findAllByNameStartsWith(String.format(NAME_STARTS_REGEX, name));
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
