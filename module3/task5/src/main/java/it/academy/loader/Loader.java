package it.academy.loader;

import it.academy.pojos.PersonTest;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;

public class Loader {

    public static void main(String[] args) {
        PersonTest person = new PersonTest(null,  "Aleksey", "Kovalchuk");
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

//        EntityManager em = HibernateUtil.getEntityManager();
//        em.getTransaction().begin();
//        em.persist(person);
//        em.getTransaction().commit();
//        HibernateUtil.close();
    }

}
