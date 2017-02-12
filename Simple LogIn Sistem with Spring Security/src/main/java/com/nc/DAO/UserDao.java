package com.nc.DAO;

import com.nc.Model.User;
import com.nc.Model.User;
import com.nc.hibernate.HibernateConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Гога on 11.04.2016.
 */
public class UserDao {
    private User user = null;

    public User findByUserName(String login) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            List<User> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public User findByUserId(Long id) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("id", id));
            List<User> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public void registUser(User user) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            User us1 = findByUserName(user.getLogin());
            if (us1 == null)
                return; // такой юзер уже существует
            session.beginTransaction();
            session.save(user);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
