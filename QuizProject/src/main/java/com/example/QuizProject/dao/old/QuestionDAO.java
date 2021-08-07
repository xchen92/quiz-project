package com.example.QuizProject.dao.old;

import com.example.QuizProject.config.MySqlDS;
import com.example.QuizProject.entity.Option;
import com.example.QuizProject.entity.Question;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_QUESTION = "SELECT * FROM question;";
    private static final String SELECT_OPTIONS = "SELECT * FROM quiz.option WHERE question_id = ?;";

    private PreparedStatement getAllQuestions;
    private PreparedStatement getOptions;

    public QuestionDAO(){
        this.ds = MySqlDS.getDs();
    }


    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            this.getAllQuestions = conn.prepareStatement(SELECT_ALL_QUESTION);

            ResultSet rs = getAllQuestions.executeQuery(SELECT_ALL_QUESTION);
            while (rs.next()) {
                /*Question question = new Question.QuestionBuilder()
                        .putID(rs.getInt("question_id"))
                        .putText(rs.getString("question_text"))
                        .putAID(rs.getInt("answer_id"))
                        .build();
                question.setOptions(getOptions(question.getQuestion_id()));
                questions.add(question);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getAllQuestions != null) getAllQuestions.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return questions;
    }

    public List<Option> getOptions(int question_id) {
        List<Option> options = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            getAllQuestions = conn.prepareStatement(SELECT_OPTIONS);
            getAllQuestions.setInt(1,question_id);

            ResultSet rs = getAllQuestions.executeQuery();
            while (rs.next()) {
               /* Option option = new Option.OptionBuilder()
                        .putID(rs.getInt("option_id"))
                        .putText(rs.getString("option_text"))
                        .putQID(rs.getInt("question_id"))
                        .build();
                options.add(option);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getAllQuestions != null) getAllQuestions.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return options;
    }

    /*public static void main(String[] args) {
        QuestionDAO dao = new QuestionDAO();
        List<Question> qs = dao.getAllQuestions();
        List<Option> ops = dao.getOptions(1);
        for(Question q: qs){
            System.out.println(q.getQuestion_text());
        }

        for(Option o: ops){
            System.out.println(o.getOption_text());
        }

    }*/


}
