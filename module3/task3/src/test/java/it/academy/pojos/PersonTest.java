package it.academy.pojos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder
public class PersonTest extends BaseTest {

    @Test
    public void createPerson() {
        Person person = new Person(1, 23, "Ivan", "Ivanov");
        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            id = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertNotNull(id);
        session.close();
    }

    @Test
    public void readPerson() {
        cleanInsert("PersonTest.xml");
        Session session = factory.openSession();
        List<Person> persons = session
                .createQuery("from Person where surname like 'Ivan%'", Person.class)
                .list();
        if (session.get(Person.class, 2) != null) {
            assertEquals(1, persons.size());
        }
        session.close();
        deleteDataset();
    }

    @Test
    public void updatePerson() {
        cleanInsert("PersonTest.xml");
        Session session = factory.openSession();
        Person person = session.get(Person.class, 2);
        Integer age = 29;
        person.setAge(age);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertEquals(age, session.get(Person.class, 2).getAge());
        session.close();
        deleteDataset();
    }

    @Test
    public void deletePerson() {
        cleanInsert("PersonTest.xml");
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, 2);
            if (person != null) {
                session.delete(person);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        assertNull(session.get(Person.class, 2));
        session.close();
        deleteDataset();
    }
}