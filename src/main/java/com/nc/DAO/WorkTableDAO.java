package com.nc.DAO;

import com.nc.hibernate.HibernateConfig;
import com.nc.model.WorkTable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Гога on 14.04.2016.
 */
public class WorkTableDAO {
    private WorkTable workTable = null;

    public void createNewWT(WorkTable workTable1) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(workTable1);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateEndTime(WorkTable workTable1, DateTime time) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            workTable1.setEndTime(time);
            session.beginTransaction();
            session.update(workTable1);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public WorkTable getWTbyUserName(String username) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(WorkTable.class);
            criteria.add(Restrictions.eq("user", username));
            criteria.add(Restrictions.eq("endtime", ""));
            List<WorkTable> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return workTable;
    }
}
