package it.academy.dao;

import it.academy.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> findAllPersons() {
        return sessionFactory
                .openSession()
                .createQuery("from Person", Person.class)
                .list();
    }

    @Override
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String id = (String) session.save(person);
        transaction.commit();
    }
}
