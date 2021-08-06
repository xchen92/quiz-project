package com.example.QuizProject.dao;

import com.example.QuizProject.config.MySqlDS;
import com.example.QuizProject.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private static final Map<String, String> USERS;
    //private List<User> my_users = getAllUsers();

    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_USER = "SELECT * FROM user;";
    private static final String INSERT_USER = "INSERT INTO user(`user_name`, `password`,`is_admin`)" +
            " VALUES (?,?,?);";

    private  static  final  String SELECT_USER = "SELECT password FROM user WHERE user_name = ?;";


    private PreparedStatement getAllUsers;
    private PreparedStatement insertUser;
    private PreparedStatement getUser;

    public UserDAO() {
        this.ds = MySqlDS.getDs();
    }

    static {
        USERS = new HashMap<String, String>() {
            {put("alicia", "1234");}
            {put("jason", "1234");}
            {put("shawn", "1234");}
            {put("kyle", "1234");}
            {put("jack", "1234");}
        };
    }

    public void addUser(String user_name, String password, boolean is_admin){
        try {
            this.conn = ds.getConnection();
            this.insertUser = conn.prepareStatement(INSERT_USER);

            insertUser.setString(1, user_name);
            insertUser.setString(2, password);
            insertUser.setBoolean(3, is_admin);

            insertUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (insertUser != null) insertUser.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            this.getAllUsers = conn.prepareStatement(SELECT_ALL_USER);

            ResultSet rs = getAllUsers.executeQuery(SELECT_ALL_USER);
            while (rs.next()) {
                User user = new User.UserBuilder()
                        .userName(rs.getString("user_name"))
                        .password(rs.getString("password"))
                        .isAdmin(rs.getBoolean("is_admin"))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (getAllUsers != null) getAllUsers.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public boolean checkAuth(String name, String password){
        ds = MySqlDS.getDs();
        try{
            conn = ds.getConnection();
            getUser = conn.prepareStatement(SELECT_USER);
            getUser.setString(1, name);
            ResultSet rs = getUser.executeQuery();
            if(rs.next()){
                String pw = rs.getString("password");
                return pw.equals(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            }catch (SQLException e){
                    e.printStackTrace();
            }
        }
        return false;
    }

    public boolean checkCredentials(String name, String password) {
        if (USERS.containsKey(name) && USERS.get(name).equals(password)) return true;
        return false;
    }
}
