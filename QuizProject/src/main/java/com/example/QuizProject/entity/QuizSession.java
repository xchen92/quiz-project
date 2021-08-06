package com.example.QuizProject.entity;

import com.example.QuizProject.dao.QuestionDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class QuizSession {
    private  int curr =0; //default
    private int quiz_id;
    private int user_id;
    private int score;
    //private QuizDAO quizDAO = new QuizDAO();
    private QuestionDAO questionDAO = new QuestionDAO();
    private Date start_time;
    private Date end_time;

    private List<Question> questions;
    private HashMap<Question, Integer> userSelectionMap = new HashMap<>();

    public QuizSession(int qid, int uid){
        this.quiz_id = qid;
        this.user_id = uid;
        questions = questionDAO.getAllQuestions();
        //questions = quizDAO.getQuestions(qid);
        //TODO: need to add more quizzes to the db in order for this to work
        start_time = new Date(System.currentTimeMillis());
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
        return 1;
    }

    public boolean quizComplete(){
        for(Question q: questions){
            if(userSelectionMap.get(questions) ==  null){
                return false;
            }
        }return true;
    }
    public void submit(){

    }

}
