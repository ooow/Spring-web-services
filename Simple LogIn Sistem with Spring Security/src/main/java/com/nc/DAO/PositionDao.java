package com.nc.DAO;

import com.nc.Model.Position;
import com.nc.hibernate.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Гога on 12.04.2016.
 */
public class PositionDao {
    public void createNewPosition(Position position) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(position);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
