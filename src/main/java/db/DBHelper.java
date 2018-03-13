package db;

import models.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {
    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static void delete(Object object){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static <T> List<T> getAll(String className) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className;
            results = session.createQuery(hql).list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Customer> getCustomers(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> customers = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Employee WHERE coffeeOrder_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            customers = query.list();
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return customers;
    }

    public static <T> T getObjectByID(String className, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className + " where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (T)query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}



