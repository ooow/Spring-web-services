package com.nc.DAO;

import com.nc.model.Position;
import com.nc.hibernate.HibernateConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Гога on 12.04.2016.
 */
public class PositionDao {
    private Position position = null;

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

    public Position getPositionByTitle(String title) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Position.class);
            criteria.add(Restrictions.eq("title", title));
            List<Position> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return position;
    }
}
