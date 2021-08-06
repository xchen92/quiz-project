package com.example.QuizProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        if (session != null) session.invalidate();

        resp.setContentType("text/html");
        req.getRequestDispatcher("/pages/login.jsp").include(req, resp);
        writer.print(
                "<div class='container'>" +
                        "<h2 style='color: green;'>Logout successfully.</h2>" +
                        "</div>"
        );
        writer.close();
    }
}
