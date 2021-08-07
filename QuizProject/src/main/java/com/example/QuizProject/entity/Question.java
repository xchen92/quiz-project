package com.example.QuizProject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    int question_id;

    @Column(name = "question_text")
    String question_text;

    @Column(name = "answer_id")
    int answer_id;


    /*
    @ManyToMany(mappedBy ="questions")
    private List<Quiz> quizzes;*/

    public Question() {

    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }


}
