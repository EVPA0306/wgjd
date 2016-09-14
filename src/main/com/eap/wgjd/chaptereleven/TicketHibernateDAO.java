package com.eap.wgjd.chaptereleven;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by evgenypavlenko on 9/9/16.
 */
public class TicketHibernateDAO {

    private static SessionFactory sessionFactory;
    private static Session session;

    public TicketHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = getSession();
    }


    public void saveTicket(Ticket ticket) {
        session.beginTransaction();
        session.save(ticket);
        session.flush();
        session.getTransaction().commit();
    }

    public void deleteTicket(Ticket ticket) {
        session.beginTransaction();
        session.delete(ticket);
        session.flush();
        session.getTransaction().commit();
    }

    private static synchronized Session getSession() {
        return sessionFactory.openSession();
    }

    public Ticket findTicketById(long ticketId) {
        Criteria criteria = session.createCriteria(Ticket.class);
        criteria.add(Restrictions.eq("ticketId",ticketId));
        List<Ticket> tickets = criteria.list();
        return tickets.get(0);
    }
}
