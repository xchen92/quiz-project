package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateUserDao;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.QuestionAnswer;
import com.example.QuizProject.entity.QuizSession;
import com.example.QuizProject.entity.Submission;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "submissionServlet", urlPatterns = {"/submission"})
public class SubmissionServlet extends HttpServlet {
    private HibernateUserDao userDao;

    public void init(){
        userDao = new HibernateUserDao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/submission.jsp");
        String user = req.getParameter("user");

        if (user != null) {
            HttpSession session = req.getSession(true);
            List<Submission> completions = userDao.getSubmission(user);
            session.setAttribute("completions", completions);
            //List<QuestionAnswer> qas = userDao.getQuestionAnswer(1);
        }

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
