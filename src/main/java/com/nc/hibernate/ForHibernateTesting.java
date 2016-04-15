package com.nc.hibernate;

import com.nc.model.Position;
import com.nc.model.Role;
import com.nc.model.User;
import com.nc.model.WorkTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

/**
 * Created by Гога on 11.04.2016.
 */
public class ForHibernateTesting {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Role rl1 = new Role();
            rl1.setTitle("ROLE_ADMIN");
            Position ps1 = new Position("manager", "static", new BigDecimal(45000));
            User us1 = new User("superUser1", "password1", "Kirill", "Mikhalkov", rl1, ps1);
            WorkTable wt1 = new WorkTable();
            wt1.setUser(us1);

            session.save(rl1);
            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            rl1 = new Role();
            rl1.setTitle("user");
            ps1 = new Position("cleaner", "static", new BigDecimal(21000));
            us1 = new User("superUser2", "password2", "Ekaterina", "Ivanova", rl1, ps1);

            session.save(rl1);
            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            ps1 = new Position("junior", "dinamic", new BigDecimal(170));
            us1 = new User("superUser3", "password3", "Anton", "Shevchenko", rl1, ps1);

            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}

