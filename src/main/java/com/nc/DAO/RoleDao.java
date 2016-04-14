package com.nc.DAO;

import com.nc.model.Role;
import com.nc.hibernate.HibernateConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Гога on 14.04.2016.
 */
public class RoleDao {
    private Role role = null;

    public void createNewRole(Role role) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(role);
            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Role getRoleByTitle(String title) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("title", title));
            List<Role> res = criteria.list();
            return res.size() != 0 ? res.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return role;
    }
}
