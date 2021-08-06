package com.example.QuizProject.controller;


import com.example.QuizProject.dao.QuizDAO;
import com.example.QuizProject.entity.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeServlet", urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {
    private QuizDAO dao;

    public void init(){
        this.dao = new QuizDAO();
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/index.jsp");
        HttpSession session = req.getSession(true);
        List<Quiz> quizzes = dao.getAllQuizzes();
        session.setAttribute("quizzes",quizzes);
        requestDispatcher.forward(req, res);

    }

}