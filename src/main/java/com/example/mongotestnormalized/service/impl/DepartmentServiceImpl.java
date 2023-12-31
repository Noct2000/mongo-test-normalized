package com.example.mongotestnormalized.service.impl;

import com.example.mongotestnormalized.model.Department;
import com.example.mongotestnormalized.repository.DepartmentRepository;
import com.example.mongotestnormalized.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(String id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No department with id: " + id));
    }

    @Override
    public Department update(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    @Transactional
    public boolean deleteById(String id) {
        boolean isExists = departmentRepository.existsById(id);
        if (isExists) {
            departmentRepository.deleteById(id);
        }
        return isExists;
    }
}
