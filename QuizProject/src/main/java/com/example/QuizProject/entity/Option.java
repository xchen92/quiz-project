package com.example.QuizProject.entity;

public class Option {
    int option_id;
    String option_text;
    int question_id;

    Option(int id, String text, int qid){
        this.option_id = id;
        this.option_text = text;
        this.question_id = qid;
    }

    public static class OptionBuilder{
        int option_id;
        String option_text;
        int question_id;

        public OptionBuilder putID(int id){
            this.option_id = id;
            return this;
        }
        public OptionBuilder putText(String text){
            this.option_text = text;
            return this;
        }
        public OptionBuilder putQID(int id){
            this.question_id = id;
            return this;
        }
        public Option build(){
            return new Option(option_id,option_text,question_id);
        }
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
