package com.example.QuizProject.dao;

import com.example.QuizProject.entity.*;

import java.util.List;

public interface QuizDao {

    List<Quiz> getQuiz();
    List<Question> getQuestions(int quiz_id);
    List<Option> getOptions(int question_id);
    boolean addSubmission(QuizSession quizSession, List<QuestionAnswer> qas);
    boolean addQuestionAnswer(QuestionAnswer questionAnswer);
}
