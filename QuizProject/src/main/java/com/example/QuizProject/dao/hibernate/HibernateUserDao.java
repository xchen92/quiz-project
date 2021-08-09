package com.example.QuizProject.dao.hibernate;

import com.example.QuizProject.config.HibernateConfigUtil;
import com.example.QuizProject.dao.UserDao;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.QuestionAnswer;
import com.example.QuizProject.entity.Submission;
import com.example.QuizProject.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

public class HibernateUserDao implements UserDao {

    public HashMap<String, String> findAll() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            HashMap<String,String> users = new HashMap<>();
            Query query = session.createQuery("FROM User");
            List<User> allUsers = query.getResultList();
            for(User u: allUsers){
                //key: name value: password
                users.put(u.getUser_name(), u.getPassword());
            }
            transaction.commit();
            return users;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addUser(String user_name, String password, boolean is_admin) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();
            User newUser = new User();
            newUser.setUser_name(user_name);
            newUser.setPassword(password);
            newUser.setIs_admin(is_admin);
            session.merge(newUser);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean checkAuth(String user_name, String password) {
        if (findAll().containsKey(user_name) && findAll().get(user_name).equals(password)) return true;
        return false;
    }

    @Override
    public List<Submission> getSubmission(String username) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Submission s WHERE s.user_name = :username");
            query.setParameter("username", username);
            List<Submission> submissions = query.getResultList();
            transaction.commit();
            return submissions;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getQuestions(List<QuestionAnswer> qas) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("SELECT q FROM Question q JOIN QuestionAnswer qa " +
                    "ON q.question_id = qa.question_id WHERE qa.submission = :submission");
            query.setParameter("submission", qas.get(0).getSubmission());
            List<Question> q = query.getResultList();
            transaction.commit();
            return q;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QuestionAnswer> getQuestionAnswer(int submissionId) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM QuestionAnswer qa WHERE qa.submission.submission_id = :submissionId");
            query.setParameter("submissionId", submissionId);
            List<QuestionAnswer> questionAnswers = query.getResultList();
            transaction.commit();
            return questionAnswers;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
