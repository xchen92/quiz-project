package com.example.QuizProject.controller;

import com.example.QuizProject.dao.FeedbackDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "feedbackServlet", value = "/feedback", loadOnStartup=1)
public class FeedbackServlet  extends HttpServlet {

    private FeedbackDAO feedbackDao;

    public void init(){feedbackDao = new FeedbackDAO();}

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "anonymous";
        //int rate = Integer.valueOf(req.getParameter("rateMe"));
        int rate = 5;
        String comment = req.getParameter("comment");
        feedbackDao.addFeedback(name,rate, comment);

        resp.setContentType("text/html");
        req.getRequestDispatcher("/pages/feedback.jsp").include(req, resp);
    }

    }
