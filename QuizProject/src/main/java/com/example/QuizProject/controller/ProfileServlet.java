package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateUserDao;
import com.example.QuizProject.entity.Submission;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "profileServlet", value = "/profile", loadOnStartup=1)
public class ProfileServlet extends HttpServlet {
    HibernateUserDao userDao;
    public void init(){
        userDao = new HibernateUserDao();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user.jsp");
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");
        List<Submission> submissions = userDao.getSubmission(username);
        session.setAttribute("completions", submissions);

        requestDispatcher.forward(req, resp);

    }
}
