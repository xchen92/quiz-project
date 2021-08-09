package com.example.QuizProject.controller;

import com.example.QuizProject.dao.hibernate.HibernateQuizDao;
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
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "submissionServlet", urlPatterns = {"/submission"})
public class SubmissionServlet extends HttpServlet {
    private HibernateUserDao userDao;
    private HibernateQuizDao quizDao;

    public void init(){
        userDao = new HibernateUserDao();
        quizDao = new HibernateQuizDao();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/submission.jsp");
        HttpSession session = req.getSession(true);

        if(req.getParameter("submissionId")!= null){
            int sid = Integer.valueOf(req.getParameter("submissionId"));
            List<QuestionAnswer> questionAnswers = userDao.getQuestionAnswer(sid);
            List<Question> questions = userDao.getQuestions(questionAnswers);
            //System.out.println("QAS" + questionAnswers);
            session.setAttribute("complete_questions", questions);
            QuizSession quizSession2 = new QuizSession();
            HashMap<Question, Integer> userSelectionMap = new HashMap<>();

            for(int i=0;i<questions.size();i++){
                userSelectionMap.put(questions.get(i),questionAnswers.get(i).getAnswer_id());
            }
            session.setAttribute("quizSession2",quizSession2);
            session.setAttribute("userSelectionMap",userSelectionMap);
        }
        List<Submission> submissions = (List<Submission>) session.getAttribute("completions");
        session.setAttribute("completions", submissions);

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/submission.jsp");
        HttpSession session = request.getSession(false);

        requestDispatcher.forward(request, response);
    }
}
