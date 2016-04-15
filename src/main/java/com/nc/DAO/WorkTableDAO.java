package com.nc.DAO;

import com.nc.hibernate.HibernateConfig;
import com.nc.model.User;
import com.nc.model.WorkTable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;

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

    public void updateEndTime(WorkTable workTable1) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Duration duration = new Duration(workTable1.getStartTime(), workTable1.getEndTime());
            LocalDate ld = new LocalDate();
            DateTime dt = new DateTime(ld.getYear(), ld.getMonthOfYear(), 1,
                    (int) (duration.getStandardHours() / 24),
                    (int) (duration.getStandardMinutes() / 60),
                    (int) (duration.getStandardSeconds() / 60));
            workTable1.setWorkTime(dt);
            session.beginTransaction();
            session.update(workTable1);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public WorkTable getWTbyUser(User user) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(WorkTable.class);
            criteria.add(Restrictions.eq("user", user));
            criteria.add(Restrictions.isNull("endTime"));
            List<WorkTable> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return workTable;
    }

    public List<WorkTable> getReportByUser(User user) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(WorkTable.class);
            criteria.add(Restrictions.eq("user", user));
            List<WorkTable> res = criteria.list();
            return res.size() != 0 ? res : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (List<WorkTable>) workTable;
    }

}
