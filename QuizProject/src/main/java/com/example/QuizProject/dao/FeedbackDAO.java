package com.example.QuizProject.dao;

import com.example.QuizProject.config.MySqlDS;
import com.example.QuizProject.entity.Feedback;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_FEEDBACK = "SELECT * FROM feedback;";
    private static final String INSERT_FEEDBACK = "INSERT INTO feedback(`user_name`, `rate`,`comment`)" +
            " VALUES (?,?,?);";

    private PreparedStatement getAllFeedbacks;
    private PreparedStatement insertFeedback;

    public FeedbackDAO(){
        this.ds = MySqlDS.getDs();
    }

    public void addFeedback(String user_name, int rate, String comment){
        try {
            this.conn = ds.getConnection();
            this.insertFeedback = conn.prepareStatement(INSERT_FEEDBACK);

            insertFeedback.setString(1, user_name);
            insertFeedback.setInt(2, rate);
            insertFeedback.setString(3, comment);

            insertFeedback.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (insertFeedback != null) insertFeedback.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            this.getAllFeedbacks = conn.prepareStatement(SELECT_ALL_FEEDBACK);

            ResultSet rs = getAllFeedbacks.executeQuery(SELECT_ALL_FEEDBACK);
            while (rs.next()) {
                Feedback feedback = new Feedback.FeedbackBuilder()
                        .getName(rs.getString("user_name"))
                        .getRate(rs.getInt("rate"))
                        .getComment(rs.getString("comment"))
                        .build();
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getAllFeedbacks != null) getAllFeedbacks.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return feedbacks;
    }


}
