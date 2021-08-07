package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateUserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private HibernateUserDao dao;

    @Override
    public void init() {
        dao = new HibernateUserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String resp = "/register-success.jsp";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        dao.addUser(username,password,false);

        request.setAttribute("user", username);
        RequestDispatcher dispatcher = request.getRequestDispatcher(resp);
        dispatcher.forward(request, response);*/

    }
}
