package com.example.QuizProject.dao.hibernate;

import com.example.QuizProject.config.HibernateConfigUtil;
import com.example.QuizProject.dao.QuizDao;
import com.example.QuizProject.entity.Option;
import com.example.QuizProject.entity.Question;
import com.example.QuizProject.entity.Quiz;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class HibernateQuizDao implements QuizDao {
    @Override
    public List<Quiz> getQuiz() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Quiz");
            List<Quiz> quizzes = query.getResultList();
            transaction.commit();
            return quizzes;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getQuestions(int quiz_id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("SELECT q FROM Question q JOIN QuizQuestion qp " +
                    "ON qp.question_id = q.question_id WHERE qp.quiz_id = :quiz_id");
            query.setParameter("quiz_id", quiz_id);
            List<Question> questions = query.getResultList();
            transaction.commit();
            return questions;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Option> getOptions(int question_id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfigUtil.getCurrentSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("FROM Option o WHERE o.question_id = :question_id");
            query.setParameter("question_id", question_id);
            List<Option> options = query.getResultList();
            transaction.commit();
            return options;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return null;
    }
}
