package com.nc.DAO;

import com.nc.exception.UsernameIsAlreadyTakenException;
import com.nc.hibernate.HibernateConfig;
import com.nc.model.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Гога on 11.04.2016.
 */
public class UserDao {
    public User findByUserName(String login) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user;
        try {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            List<User> res = criteria.list();
            if (res.size() != 0)
                user = res.get(0);
            else user = null;
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        } finally {
            session.close();
        }
        return user;
    }

    public void registUser(User user) throws UsernameIsAlreadyTakenException {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            User us1 = findByUserName(user.getLogin());
            if (us1 != null)
                throw new UsernameIsAlreadyTakenException("This username: " + user.getLogin() + " is already taken");
            session.beginTransaction();
            session.save(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateUser(User user) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public String[][] getUsers() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        String[][] logins = null;
        List<String> login;
        List<String> names;
        try {
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT login from users");
            login = query.list();
            query = session.createSQLQuery("SELECT name from users");
            names = query.list();
            logins = new String[login.size()][2];
            for (int i = 0; i < login.size(); i++) {
                logins[i][0] = login.get(i);
                logins[i][1] = names.get(i);
            }
            session.beginTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return logins;
    }
}
