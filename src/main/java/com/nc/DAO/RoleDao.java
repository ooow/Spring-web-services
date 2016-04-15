package com.nc.DAO;

import com.nc.exception.AlreadyCreatedException;
import com.nc.exception.RoleDoesNotExistException;
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

    public void createNewRole(Role role) throws AlreadyCreatedException {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            try {
                new RoleDao().getRoleByTitle(role.getTitle());
                throw new AlreadyCreatedException("The role: " + role.getTitle() + " has already been created");
            } catch (RoleDoesNotExistException e) {
                session.beginTransaction();
                session.save(role);
                session.beginTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Role getRoleByTitle(String title) throws RoleDoesNotExistException {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(Role.class);
            criteria.add(Restrictions.eq("title", title));
            List<Role> res = criteria.list();
            if (res.size() != 0) return res.get(0);
            else
                throw new RoleDoesNotExistException("This role: " + title + " does not exist");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return role;
    }
}
