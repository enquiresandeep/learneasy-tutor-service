package com.learneasy.user.infrastructure;

import com.learneasy.user.domain.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorRepository extends MongoRepository<Tutor,String> {

    Optional<Tutor> findById(String tutorId);

}
