package com.example.QuizProject.dao;

import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.QuestionAnswer;
import com.example.QuizProject.entity.Submission;
import com.example.QuizProject.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    HashMap<String, String> findAll();
    boolean addUser(String user_name, String password, boolean is_admin);
    boolean checkAuth(String user_name, String password);

    List<Submission> getSubmission(String username);
    List<Question> getQuestions(List<QuestionAnswer> qas);
    List<QuestionAnswer> getQuestionAnswer(int submissionId);

}
