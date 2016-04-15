package com.nc.DAO;

import com.nc.exception.AlreadyCreatedException;
import com.nc.exception.PositionDoesNotExistException;
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

    public void createNewPosition(Position position) throws AlreadyCreatedException {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            try {
                new PositionDao().getPositionByTitle(position.getTitle());
                throw new AlreadyCreatedException("The position: " + position.getTitle() + " has already been created");
            } catch (PositionDoesNotExistException e) {
                session.beginTransaction();
                session.save(position);
                session.beginTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Position getPositionByTitle(String title) throws PositionDoesNotExistException {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Position.class);
            criteria.add(Restrictions.eq("title", title));
            List<Position> res = criteria.list();
            if (res.size() != 0) return res.get(0);
            else
                throw new PositionDoesNotExistException("This position: " + title + " does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return position;
    }
}
