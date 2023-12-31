package com.example.mongotestnormalized.service;

import com.example.mongotestnormalized.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService extends CrudService<Student, String> {
    List<Student> getAll(Integer page, Integer limit, Optional<String> sort);

    List<Student> getAllByName(String name);

    List<Student> getAllByNameAndEmail(String name, String email);

    List<Student> getAllByNameOrEmail(String name, String email);

    List<Student> getAllByEmailLike(String email);

    List<Student> getAllByNameStartsWith(String name);
}
