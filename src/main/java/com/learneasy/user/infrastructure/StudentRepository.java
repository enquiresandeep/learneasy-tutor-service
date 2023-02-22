package com.learneasy.user.infrastructure;

import com.learneasy.user.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

    Optional<Student> findById(String studentId);

}
