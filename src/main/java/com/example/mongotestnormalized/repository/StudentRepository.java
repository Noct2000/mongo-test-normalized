package com.example.mongotestnormalized.repository;

import com.example.mongotestnormalized.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query(value = "{'name' :  ?0}")
    List<Student> findAllByName(String name);

    @Query(value = "{'name' : ?0, 'mail' : ?1}")
    List<Student> findAllByNameAndEmail(String name, String email);

    @Query(value = "{$or :  [{'name' :  ?0}, {'mail' :  ?1}]}")
    List<Student> findAllByNameOrEmail(String name, String email);

    @Query(value = "{'mail' : {$regex : ?0}}")
    List<Student> findAllByEmailLike(String email);

    @Query(value = "{'name' : {$regex : ?0}}")
    List<Student> findAllByNameStartsWith(String name);
}
