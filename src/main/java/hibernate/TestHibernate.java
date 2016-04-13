package hibernate;

import DAO.UserDao;
import Model.Position;
import Model.Role;
import Model.User;
import Model.WorkTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Гога on 11.04.2016.
 */
public class TestHibernate {
    public void main(String[] args) {
        /*SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Role rl1 = new Role();
            rl1.setTitle("admin");
            Position ps1 = new Position("Manager", "static", new BigDecimal(45000));
            User us1 = new User("superUser1", "password1", "Kirill", "Mikhalkov", rl1, ps1);
            WorkTable wt1 = new WorkTable(us1, new Date(2016, 04, 12), new Time(11, 30, 0));
            wt1.setEndTime(new Time(18, 0, 0));

            session.save(rl1);
            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            rl1 = new Role();
            rl1.setTitle("user");
            ps1 = new Position("Cleaner", "static", new BigDecimal(21000));
            us1 = new User("superUser2", "password2", "Ekaterina", "Ivanova", rl1, ps1);
            wt1 = new WorkTable(us1, new Date(2016, 04, 13), new Time(10, 20, 0));
            wt1.setEndTime(new Time(16, 30, 0));

            session.save(rl1);
            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            ps1 = new Position("Junior", "dinamic", new BigDecimal(170));
            us1 = new User("superUser3", "password3", "Anton", "Shevchenko", rl1, ps1);
            wt1 = new WorkTable(us1, new Date(2016, 04, 13), new Time(12, 0, 0));
            wt1.setEndTime(new Time(19, 0, 0));

            session.save(ps1);
            session.save(us1);
            session.save(wt1);

            *//*session.createSQLQuery("SELECT * FROM users");*//*

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
*/
    }
}
