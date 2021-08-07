package com.example.QuizProject.entity;

import javax.persistence.*;

@Entity
@Table(name="option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private int option_id;

    @Column(name = "option_text")
    private String option_text;

    @Column(name = "question_id")
    private int question_id;

    public Option() {

    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }

    public String getOption_text() {
        return option_text;
    }

    public void setOption_text(String option_text) {
        this.option_text = option_text;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }


}
