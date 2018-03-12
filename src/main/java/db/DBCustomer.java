package db;

import models.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBCustomer {

    private static Transaction transaction;
    private static Session session;

    public static void save(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();

        }
    }
    public static List<Customer> getCustomer(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Customer";
            customers = session.createQuery(hql).list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();

        }
        return customers;
    }
}

