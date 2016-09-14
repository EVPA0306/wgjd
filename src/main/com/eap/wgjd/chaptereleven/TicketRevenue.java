package com.eap.wgjd.chaptereleven;

import java.math.BigDecimal;

/**
 * Created by evgenypavlenko on 9/6/16.
 */
public class TicketRevenue {

    private final static int TICKET_PRICE = 30;

    public BigDecimal estimateTotalRevenue(int numberOfTicketsSold) throws IllegalArgumentException {

        BigDecimal totalRevenue = BigDecimal.ZERO;

        if (numberOfTicketsSold < 0 || numberOfTicketsSold > 100) {
            throw new IllegalArgumentException("# tickets sold must be == 1..100");
        }

        /*if (numberOfTicketsSold > 100) {
            throw new IllegalArgumentException("Must be < 100");
        }*/

        //if (numberOfTicketsSold == 1) {
            totalRevenue = new BigDecimal(TICKET_PRICE * numberOfTicketsSold);
        //}
        return totalRevenue;
    }
}
