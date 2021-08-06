package com.example.QuizProject.entity;

import java.util.List;

public class Question {
    int question_id;
    String question_text;
    int answer_id;
    List<Option> options;

    Question(int id, String text, int aid){
        this.question_id = id;
        this.question_text = text;
        this.answer_id = aid;
    }

    public static class QuestionBuilder{
        int question_id;
        String question_text;
        int answer_id;

        public QuestionBuilder putID(int id){
            this.question_id = id;
            return this;
        }
        public QuestionBuilder putText(String text){
            this.question_text = text;
            return this;
        }
        public QuestionBuilder putAID(int id){
            this.answer_id = id;
            return this;
        }
        public Question build(){
            return new Question(question_id,question_text,answer_id);
        }
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

    public void setOptions(List<Option> opts){
        this.options = opts;
    }

    public List<Option> getOptions(){
        return this.options;
    }


}
