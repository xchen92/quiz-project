package com.example.QuizProject.service;

import com.example.QuizProject.dao.UserDAO;

public class LoginService {
    private static LoginService ls;


    private LoginService() {

    }

    public static LoginService getInstance() {
        if(ls == null) {
            ls = new LoginService();
        }

        return ls;
    }

    public boolean checkLogin(String username,String password) {
        UserDAO auth = new UserDAO();

        if(password == null) {
            return false;
        } else {
            return auth.checkAuth(username,password);
        }

    }
}
