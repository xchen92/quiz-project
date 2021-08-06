package com.example.QuizProject.dao;

import com.example.QuizProject.config.MySqlDS;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.Quiz;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {
    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_QUIZZES = "SELECT * FROM quiz;";
    private static final String SELECT_QUESTIONS = "SELECT * FROM quiz.question WHERE " +
            "question_id IN" +
            "(SELECT question_id FROM quiz.quiz_question WHERE quiz_id =? );";

    private PreparedStatement getAllQuizzes;
    private PreparedStatement getQuestions;

    public QuizDAO(){
        this.ds = MySqlDS.getDs();
    }



    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            this.getAllQuizzes = conn.prepareStatement(SELECT_ALL_QUIZZES);

            ResultSet rs = getAllQuizzes.executeQuery(SELECT_ALL_QUIZZES);
            while (rs.next()) {
                Quiz quiz = new Quiz.QuizBuilder()
                        .putID(rs.getInt("quiz_id"))
                        .putName(rs.getString("quiz_name"))
                        .build();
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getAllQuizzes != null) getAllQuizzes.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return quizzes;
    }

    public List<Question> getQuestions(int quiz_id) {
        List<Question> questions = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            getQuestions = conn.prepareStatement(SELECT_QUESTIONS);
            getQuestions.setInt(1,quiz_id);


            ResultSet rs = getQuestions.executeQuery();
            while (rs.next()) {
                Question question = new Question.QuestionBuilder()
                        .putID(rs.getInt("question_id"))
                        .putText(rs.getString("question_text"))
                        .putAID(rs.getInt("answer_id"))
                        .build();
                questions.add(question);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getQuestions != null) getQuestions.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }

    /* DEBUG ONLY
    public static void main(String[] args) {
        QuizDAO dao = new QuizDAO();
        List<Quiz> qZ= dao.getAllQuizzes();
        for(Quiz q: qZ){
            System.out.println(q.getQuiz_name());
        }

        List<Question> qs= dao.getQuestions(1);
        for(Question q: qs){
            System.out.println(q.getQuestion_text());
        }
    }*/
}
