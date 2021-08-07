package com.example.QuizProject.dao.hibernate;

import com.example.QuizProject.config.HibernateConfigUtil;
import com.example.QuizProject.dao.UserDao;
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
}