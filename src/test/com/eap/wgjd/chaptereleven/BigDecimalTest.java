package com.eap.wgjd.chaptereleven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by evgenypavlenko on 9/7/16.
 */
public class BigDecimalTest {
    private BigDecimal x;

    @Before
    public void setUp() {
        x = new BigDecimal("1.5");
    }

    @Test
    public void addingTwoDecimal() {
        assertEquals(new BigDecimal("3.0"),x.add(x));

    }

    @Test(expected = NumberFormatException.class)
    public void numberFormatExceptionIsNotANumber() {
        x = new BigDecimal("It is not a number");
        //x = new BigDecimal("10");
    }

    @After
    public void tearDown() {
        x = null;
    }
}
