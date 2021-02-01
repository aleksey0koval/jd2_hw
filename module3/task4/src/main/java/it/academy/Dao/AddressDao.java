package it.academy.Dao;

import it.academy.pojos.Address;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDao implements Dao<Address, Integer> {

    private Session session;

    @Override
    public void create(Address address) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(address);
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
    public Address read(Integer addressId) {
        session = HibernateUtil.getSession();
        Address address = session.get(Address.class, addressId);
        if (address != null) {
            System.out.println(address);
        } else {
            System.out.println("Unable to find: no such address was found");
        }
        session.close();
        return address;
    }

    @Override
    public void update(Address address) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(address);
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
    public void delete(Address address) {
        session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (address != null) {
                System.out.println(address + " deleted!");
                session.delete(address);
            } else {
                System.out.println("Unable to delete: no such address found!");
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
