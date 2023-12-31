package com.example.mongotestnormalized.service;

import com.example.mongotestnormalized.model.Subject;
import java.util.List;

public interface SubjectService extends CrudService<Subject, String> {
    List<Subject> getAllByIdIn(List<String> ids);
}
