package com.example.QuizProject.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quiz_id;

    @Column(name = "quiz_name")
    private String quiz_name;


    @Column(name = "quiz_img")
    private String quiz_img;


    @OneToMany
    @JoinTable(name = "quiz_question",
            joinColumns = {@JoinColumn(name = "quiz_id")})
    private List<Question> questions;


    public Quiz(){
    }

    //setters and getters
    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public String getQuiz_img() {
        return quiz_img;
    }

    public void setQuiz_img(String quiz_img) {
        this.quiz_img = quiz_img;
    }
}
