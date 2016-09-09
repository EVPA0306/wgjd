package com.eap.wgjd.chaptereleven;

import org.junit.Test;
//import sun.security.krb5.internal.Ticket;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by evgenypavlenko on 9/7/16.
 */
public class TestTicket {
    @Test
    public void tenPercentDiscount() {
        String dummyName = "Riley";
        Ticket ticket = new Ticket(new BigDecimal("10"));
        assertEquals(new BigDecimal("9.0"),ticket.getDiscountPrice());
    }
}
