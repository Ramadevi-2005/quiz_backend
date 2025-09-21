package com.klef.fsad.sdp.repository;

import com.klef.fsad.sdp.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}