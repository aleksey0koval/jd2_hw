package it.academy.loader;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonLoader {

    private static Session session;

    public static void main(String[] args) {
        Person person = new Person(1, 29, "Ivan", "Ivanov");
        createPerson(person);

        readPerson(1);
        readPerson(2);

        person.setAge(99);
        updatePerson(person);

        deletePerson(1);
        deletePerson(1);
    }

    private static void createPerson(Person person) {
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

    private static Person readPerson(Integer idPerson) {
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

    private static void updatePerson(Person person) {
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

    private static void deletePerson(Integer idPerson) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, idPerson);
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