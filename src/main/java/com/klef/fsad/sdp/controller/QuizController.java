package com.klef.fsad.sdp.controller;

import com.klef.fsad.sdp.Quiz;
import com.klef.fsad.sdp.repository.QuizRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    // Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Create new quiz
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get quiz by ID
    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizRepository.findById(id).orElseThrow();
    }
}
