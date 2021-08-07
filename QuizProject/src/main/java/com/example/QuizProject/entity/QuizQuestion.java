package com.example.QuizProject.entity;

import javax.persistence.*;

@Entity
@Table(name="quiz_question")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_question_id")
    private int quiz_question_id;

    @Column(name = "quiz_id")
    private int quiz_id;

    @Column(name = "question_id")
    private int question_id;
}
