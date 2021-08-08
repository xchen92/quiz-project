package com.example.QuizProject.entity;

import com.example.QuizProject.dao.QuizDao;
import com.example.QuizProject.dao.hibernate.HibernateQuizDao;


import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class QuizSession {
    private  int curr = 0; //default
    private int quiz_id;
    private String quizName;
    private String username;
    private int score = 0; //default
    Submission submission;

    private HibernateQuizDao quizDao = new HibernateQuizDao();
    private Date start_time;
    private Date end_time;

    private List<Question> questions;
    private HashMap<Question, Integer> userSelectionMap = new HashMap<>();

    public QuizSession(int qid, String username){
        this.quiz_id = qid;
        this.username = username;
        questions = quizDao.getQuestions(qid);
        //TODO: need to add more quizzes to the db in order for this to work
        start_time = new Date(System.currentTimeMillis());
    }

    public List<Option> getOptions(int question_id){
        return quizDao.getOptions(question_id);
    }


    public Question getCurrentQuestion(){
        return questions.get(curr);
    }

    public void setUserSelection(int option_id){
        userSelectionMap.put(questions.get(curr), option_id);
    }

    public int getScore(){
        return score;
    }

    public int getCurr(){
        return curr;
    }

    public void next(){
        if(curr < questions.size()-1){
            curr++;
        }
    }

    public void previous(){
        if(curr > 0){
            curr--;
        }
    }

    public int getSelected(){
        Integer i = userSelectionMap.get(questions.get(curr));
        if(i == null){
            return 0;
        }
        return i;
    }

    public boolean quizComplete(){
        for(Question q: questions){
            if(userSelectionMap.get(q) ==  null){
                return false;
            }
        }return true;
    }
    public void submit(QuizDao qd){
        submission = new Submission();
        submission.setUser_name(username);
        quizName = quizDao.getQuizName(quiz_id);
        submission.setQuiz_name(quizName);
        //end_time = new Timestamp(System.currentTimeMillis());
        //submission.setEnd_time((java.sql.Date) end_time);
        //submission.setStart_time((java.sql.Date) start_time);
        List<QuestionAnswer> questionAnswers = new ArrayList<>();

        for(Question q: questions){
            if(q.getAnswer_id() == userSelectionMap.get(q)){
                score++;
            }
            QuestionAnswer qa = new QuestionAnswer();
            Integer optionId = userSelectionMap.get(q);
            if(optionId != null){
                qa.setAnswer_id(optionId);
            }
            qa.setQuestion_id(q.getQuestion_id());
            System.out.println(qa.getAnswer_id());
            System.out.println("submissionID: "+submission.getSubmission_id());
            questionAnswers.add(qa);
        }
        submission.setQas(questionAnswers);
        submission.setScore(getScore());

        qd.addSubmission(this, questionAnswers);

    }

    public Submission getSubmission(){
        return submission;
    }

}
