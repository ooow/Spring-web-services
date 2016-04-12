package DAO;

import Model.User;
import hibernate.HibernateConfig;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Гога on 12.04.2016.
 */
public class ModelDao {

    /*public List<String> getStatisticColumNames(){
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }*/
}
