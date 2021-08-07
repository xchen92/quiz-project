package com.example.QuizProject.dao;

import com.example.QuizProject.entity.Option;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.Quiz;

import java.util.List;

public interface QuizDao {

    List<Quiz> getQuiz();
    List<Question> getQuestions(int quiz_id);
    List<Option> getOptions(int question_id);
}
