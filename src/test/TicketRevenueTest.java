package test;

import com.eap.wgjd.chaptereleven.TicketRevenue;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;
import java.math.BigDecimal;

/**
 * Created by evgenypavlenko on 9/6/16.
 */
public class TicketRevenueTest {

    private TicketRevenue venueRevenue;
    private BigDecimal expectedRevenue;

    @Before
    public void setUp() {
        venueRevenue = new TicketRevenue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failLessThanZeroTicketsAreSold() {
        venueRevenue.estimateTotalRevenue(-1);
    }

    @Test
    public void zeroSalesEqualsZeroRevenue() {
        assertEquals(BigDecimal.ZERO,venueRevenue.estimateTotalRevenue(0));
    }

    @Test
    public void tenTicketsSoldRevenue() {
        expectedRevenue = new BigDecimal("300");
        assertEquals(expectedRevenue, venueRevenue.estimateTotalRevenue(10));
    }

    @Test
    public void oneTicketSoldIsThirtyInRevenue() {
        expectedRevenue = new BigDecimal("30");
        assertEquals(expectedRevenue, venueRevenue.estimateTotalRevenue(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failIfMoreThanHandredTicketsSold() {
        venueRevenue.estimateTotalRevenue(101);
    }
}

