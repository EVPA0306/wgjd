package com.eap.wgjd.chaptereleven;

import java.math.BigDecimal;

/**
 * Created by evgenypavlenko on 9/7/16.
 */
public class Ticket {

    private final static int BASIC_TICKETED_PRICE = 30;
    private final static BigDecimal DISCOUNT_RATE = new BigDecimal("1.0");

    //private final String customerName;
    private BigDecimal price;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    private long ticketId;

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    private BigDecimal faceValue = null;
    private BigDecimal discountRate;


    public Ticket() {
        this.price = new BigDecimal(BASIC_TICKETED_PRICE);
    }

    public Ticket(long ticketId) {
        this.ticketId = ticketId;
        this.price = new BigDecimal(BASIC_TICKETED_PRICE);
    }

    public Ticket(BigDecimal price) {
        this.price = price;
    }

    private final class FixedPrice implements Price{
        public BigDecimal getInitialPrice() {
            return new BigDecimal(BASIC_TICKETED_PRICE);
        }
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public BigDecimal getDiscountPrice() {
        return price.multiply(DISCOUNT_RATE);
    }
}
