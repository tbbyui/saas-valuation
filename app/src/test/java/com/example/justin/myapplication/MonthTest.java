package com.example.justin.myapplication;

import org.junit.Test;

import static junit.framework.Assert.*;
import static org.junit.Assert.assertEquals;

public class MonthTest {
    @Test
    public void Month1IncAndDec() {
        Month m1 = null;
        boolean thrown = false;
        try {
            m1 = Month.of(1);
        } catch (Month.OutsideMonthBoundsException e) {
            thrown = true;
        }
        assertFalse(thrown);

        assertEquals(Month.JANUARY,  m1);
        assertEquals(Month.FEBRUARY, m1.getNextMonth());
        assertEquals(Month.DECEMBER, m1.getPrevMonth());

    }

    @Test
    public void Montth12IncAndDec() {
        Month m12 = null;
        boolean thrown = false;
        try {
            m12 = Month.of(12);
        } catch (Month.OutsideMonthBoundsException e) {
            thrown = true;
        }
        assertFalse(thrown);

        assertEquals(Month.DECEMBER,  m12);
        assertEquals(Month.JANUARY, m12.getNextMonth());
        assertEquals(Month.NOVEMBER, m12.getPrevMonth());
    }

    @Test
    public void MonthOf13ThrowErr() {
        Month m13 = null;
        boolean thrown = false;
        try{
            m13 = Month.of(13);
        } catch (Month.OutsideMonthBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void MonthOf0ThrowErr() {
        Month m0 = null;
        boolean thrown = false;
        try{
            m0 = Month.of(0);
        } catch (Month.OutsideMonthBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}
