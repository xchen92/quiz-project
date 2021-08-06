package com.example.QuizProject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "profileServlet", value = "/profile", loadOnStartup=1)
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        HttpSession oldSession = req.getSession(false);
        if (oldSession == null) {
            req.getRequestDispatcher("/pages/login.jsp").include(req, resp);
            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Unauthorized access, please login.</h2>" +
                            "</div>"
            );
        } else {
            String userName = (String)oldSession.getAttribute("username");
            String password = (String)oldSession.getAttribute("password");
            req.getRequestDispatcher("/pages/user.jsp").include(req, resp);
        }

        writer.close();
    }
}
