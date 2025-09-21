package com.klef.fsad.sdp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "type", nullable = false)
    private String type; // "multiple" or "truefalse"

    // ✅ Changed from int → Integer so it can handle null
    @Column(name = "correct_answer")
    private Integer correctAnswer; // index of correct option (nullable)

    // Options stored in separate table (question_options)
    @ElementCollection
    @CollectionTable(
        name = "question_options",
        joinColumns = @JoinColumn(name = "question_id")
    )
    @Column(name = "options")
    private List<String> options;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    @JsonBackReference   // ✅ Prevents infinite recursion
    private Quiz quiz;

    // --- Constructors ---
    public Question() {}

    public Question(String questionText, String type, Integer correctAnswer, List<String> options) {
        this.questionText = questionText;
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
