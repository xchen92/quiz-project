package com.example.QuizProject.entity;

import java.security.PublicKey;

public class Feedback {
    //private int feedback_id;
    private String user_name;
    private int rate;
    private String comment;

    public Feedback(String name, int rate, String comment){
        //this.feedback_id = id;
        this.user_name = name;
        this.rate = rate;
        this.comment = comment;
    }

    public static class FeedbackBuilder{
        //private int feedback_id;
        private String user_name;
        private int rate;
        private String comment;

       /* public FeedbackBuilder getID(int id){
            this.feedback_id = id;
            return this;
        }*/

        public FeedbackBuilder getName(String name){
            this.user_name = name;
            return this;
        }

        public FeedbackBuilder getRate(int rate){
            this.rate = rate;
            return this;
        }

        public FeedbackBuilder getComment(String comment){
            this.comment = comment;
            return this;
        }

        public Feedback build(){
            return new Feedback(user_name,rate,comment);
        }

    }
}
