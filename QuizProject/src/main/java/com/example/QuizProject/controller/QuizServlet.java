package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateQuizDao;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.QuizSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "quizServlet", urlPatterns = {"/quiz"})
public class QuizServlet extends HttpServlet {
    private HibernateQuizDao quizDao;

    public void init(){
        quizDao = new HibernateQuizDao();
    }

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/quiz.jsp");

        String quiz_id = req.getParameter("quiz");
        //debug
        //System.out.println("quiz id: " +quiz_id);
        String user = req.getParameter("user");
        //debug
         //System.out.println("user id: " +user_id);

        if (quiz_id != null) {
            int quiz = Integer.parseInt(quiz_id);

            HttpSession session = req.getSession(true);
            QuizSession quizSession = new QuizSession(quiz, user);
            session.setAttribute("quizSession", quizSession);
            List<Question> questions = quizDao.getQuestions(quiz);
            session.setAttribute("questions",questions);
        }
        requestDispatcher.forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/quiz.jsp");
        HttpSession session = req.getSession(false);
        if(session != null){
            String option_id = req.getParameter("option");
            //System.out.println("optinID: "+option_id);
            if(option_id!= null){
                try{
                    int id= Integer.parseInt(option_id);
                    QuizSession quizSession = (QuizSession) session.getAttribute("quizSession");
                    quizSession.setUserSelection(id);
                    //System.out.println("selected id: "+ id);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }


        if(session !=null){
            QuizSession quizSession = (QuizSession) session.getAttribute("quizSession");
            session.setAttribute("selectedID",quizSession.getSelected());
            System.out.println("selected:"+quizSession.getSelected());
            if(req.getParameter("button").equals("previous")){
                quizSession.previous();
            }else if(req.getParameter("button").equals("next")){
                quizSession.next();
            }else if(req.getParameter("button").equals("submit")){
                if(quizSession.quizComplete()){
                    quizSession.submit(quizDao);
                    requestDispatcher = req.getRequestDispatcher("/pages/index.jsp");
                    //System.out.println("DONE");
                }else{
                    session.setAttribute("msg","Not done yet.");
                    //System.out.println("NOT DONE");
                }
            }
        }

        requestDispatcher.forward(req, res);
    }
}
