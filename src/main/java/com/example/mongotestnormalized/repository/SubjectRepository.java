package com.example.mongotestnormalized.repository;

import com.example.mongotestnormalized.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
    List<Subject> findAllByIdIn(List<String> ids);
}
