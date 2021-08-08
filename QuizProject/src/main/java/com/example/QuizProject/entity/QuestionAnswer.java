package com.example.QuizProject.entity;

import javax.persistence.*;

@Entity
@Table(name="question_answer")
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_answer_id")
    private int question_answer_id;

    @Column(name = "submission_id")
    private int submission_id;

    @Column(name = "question_id")
    private int question_id;

    @Column(name = "answer_id")
    private  int answer_id;

    public QuestionAnswer(){}


    public int getQuestion_answer_id() {
        return question_answer_id;
    }

    public void setQuestion_answer_id(int question_answer_id) {
        this.question_answer_id = question_answer_id;
    }

    public int getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(int submission_id) {
        this.submission_id = submission_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

}
