package com.example.QuizProject.entity;

import javax.persistence.*;

@Entity
@Table(name="option")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Integer option_id;

    @Column(name = "option_text")
    private String option_text;

    @Column(name = "question_id")
    private Integer question_id;

}
