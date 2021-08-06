package com.example.QuizProject.entity;

import java.util.ArrayList;

public class Quiz {

    private int quiz_id;
    private String quiz_name;
    private ArrayList<Question> questions;
    private String img = "java.jpg";//default

    public Quiz(int id, String name){
        this.quiz_id = id;
        this.quiz_name = name;
        setImg(id);
    }

    public Quiz(String name){
        this.quiz_name = name;
    }

    public void addQuestions(Question q){
        questions.add(q);
    }

    public static class QuizBuilder{
        private int quiz_id;
        private String quiz_name;
        //private ArrayList<Question> questions;

        public QuizBuilder putID(int id){
            this.quiz_id = id;
            return this;
        }

        public QuizBuilder putName(String name){
            this.quiz_name = name;
            return this;
        }

        public Quiz build(){
            return new Quiz(quiz_id,quiz_name);
        }

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

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setImg(int id){
        switch (id){
            case 1:
                this.img = "java.jpg";
                break;
            case 2:
                this.img = "sql-logo.jpg";
                break;
            case 3:
                this.img = "css.jpg";
                break;
            case 4:
                this.img = "javascript.jpg";
        }
    }
    public String getImg(){
        return this.img;
    }
}
