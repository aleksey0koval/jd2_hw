package it.academy.Dao;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao implements Dao<Person, Integer> {

    private Session session;

    @Override
    public void create(Person person) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Person read(Integer idPerson) {
        session = HibernateUtil.getSession();
        Person person = session.get(Person.class, idPerson);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Unable to find: no such person was found");
        }
        session.close();
        return person;
    }

    @Override
    public void update(Person person) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Person person) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (person != null) {
                System.out.println(person + " deleted!");
                session.delete(person);
            } else {
                System.out.println("Unable to delete: no such person found!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
