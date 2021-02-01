package it.academy;

import it.academy.per.*;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Loader {

    public static void main(String[] args) {
        IdentityClass identity = new IdentityClass(null);
        IncrementClass increment = new IncrementClass(null);
        SequenceClass sequence = new SequenceClass(null);
        HiloClass hilo = new HiloClass(null);
        SeqhiloClass seqhilo = new SeqhiloClass(null);
        UuidClass uuid = new UuidClass(null);

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(identity);
            session.save(increment);
            session.save(sequence);
            session.save(hilo);
            session.save(seqhilo);
            session.save(uuid);
            tx.commit();

            System.out.println("identity " + session.getIdentifier(identity));
            System.out.println("increment " + session.getIdentifier(increment));
            System.out.println("sequence " + session.getIdentifier(sequence));
            System.out.println("hilo" + session.getIdentifier(hilo));
            System.out.println("seqhilo " + session.getIdentifier(seqhilo));
            System.out.println("uuid " + session.getIdentifier(uuid));

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
