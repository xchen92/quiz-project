package com.example.QuizProject.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession(true);
        String user = (String) session.getAttribute("username");
        if(user ==null){
            dispatcher = request.getRequestDispatcher("login");
            session.setAttribute("msg", "Please Login");
            dispatcher.forward(request,response);
        }else{
            chain.doFilter(request, response);
        }

    }
}
