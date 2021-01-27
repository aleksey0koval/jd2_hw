package it.academy.loader;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonLoader {

    private static Session session;

    public static void main(String[] args) {

        createPerson(new Person(1, 29, "Ivan", "Ivanov"));

        session = HibernateUtil.getSession();
        Person person = session.get(Person.class, 1);

        System.out.println("1\n" + person);

        person.setAge(35);
        person.setName("Petr");

        Transaction tx = null;
        try {
            session.beginTransaction();
            session.saveOrUpdate(person);
            session.flush();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        System.out.println("2\n" + person);

        person.setAge(29);
        person.setName("Ivan");

        try {
            session.saveOrUpdate(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        System.out.println("3\n" + person);

        person.setName("Petr");
        person.setAge(35);

        System.out.println("4\n" + person);

        session.refresh(person);

        System.out.println("5\n" + person);
        session.close();
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
