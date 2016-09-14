package test;

import com.eap.wgjd.chaptereleven.Ticket;
import com.eap.wgjd.chaptereleven.TicketHibernateDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by evgenypavlenko on 9/9/16.
 */
public class TicketHibernateDAOTest {

    private static SessionFactory factory;
    private static TicketHibernateDAO ticketDAO;
    private Ticket ticket;
    private Ticket ticket2;

    @BeforeClass
    public static void baseSetUp() {
        factory = new Configuration()
                .configure("/resources/hibernate.cfg.xml")
                .buildSessionFactory();
        ticketDAO = new TicketHibernateDAO(factory);
    }
    @Before
    public void setUpTest() {
        ticket = new Ticket(1);
        ticketDAO.saveTicket(ticket);
        ticket2 = new Ticket(2);
        ticketDAO.saveTicket(ticket2);
    }
    @Test
    public void findTicketByHappyPath() {
        Ticket ticket = ticketDAO.findTicketById(1);
        assertEquals(new BigDecimal("30.0"),ticket.getDiscountPrice());
    }

    @After
    public void tearDown(){
        ticketDAO.deleteTicket(ticket);
        ticketDAO.deleteTicket(ticket2);
    }
    @AfterClass
    public  static void baseTearDown() {
        factory.close();
    }
}
