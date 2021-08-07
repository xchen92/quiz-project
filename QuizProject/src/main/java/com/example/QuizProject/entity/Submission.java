package com.example.QuizProject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="submission")
public class Submission {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="submission_id")
    private Integer submission_id;

    @Column(name="user_name")
    private String user_name;

    @Column(name="start_time")
    private Date start_time;

    @Column(name="end_time")
    private Date end_time;

    @Column(name="score")
    private Integer score;

    public Integer getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(Integer submission_id) {
        this.submission_id = submission_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


}
