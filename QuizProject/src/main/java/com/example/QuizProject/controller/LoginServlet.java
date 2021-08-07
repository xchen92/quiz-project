package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateUserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet {
    private HibernateUserDao userDAO;

    public void init() {
        this.userDAO = new HibernateUserDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username!=null && password!=null && userDAO.checkAuth(username, password)) {
            // get the old session
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            // generate a new Session
            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("username", username);
            newSession.setAttribute("password", password);

            // setting session to expire in 10 minutes
            newSession.setMaxInactiveInterval(10 * 60);
            resp.sendRedirect(req.getContextPath() + "/profile");
        } else {
            resp.setContentType("text/html");
            req.getRequestDispatcher("/pages/login.jsp").include(req, resp);
        }
    }
}
