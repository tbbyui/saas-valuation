package com.example.justin.myapplication;

import android.app.Fragment;

import com.example.justin.myapplication.model.CustomersInfo;

import static junit.framework.Assert.*;
import org.junit.Test;

public class CustomersInQuarterTest {
    @Test
    public void constructorTest() {
        final Month currentMonth = Month.MARCH;
        final int endOfLastMonth = 120;
        final int lostDuringLastMonth = 20;
        final int endOfPrevMonth = 100;
        final float churn = 0.2f;

        CustomersInfo q = new CustomersInfo(
                currentMonth,
                endOfLastMonth,
                lostDuringLastMonth,
                endOfPrevMonth
        );

        assertEquals(q.getEarliestCustomerData().getMonth(), currentMonth.getPrevMonth());
        assertEquals(q.getEarliestCustomerData().getCustomers(), endOfPrevMonth);
        assertEquals(q.getEarliestCustomerData().getLoss(), lostDuringLastMonth);
        assertEquals(q.getEarliestCustomerData().getChurn(), churn);
    }

    @Test
    public void addMonthTest() {
        final Month currentMonth = Month.MARCH;
        final int endOfLastMonth = 120;
        final int m1Loss = 20;
        final int m1Customers = 100;

        final int m2Loss = 20;
        final int m2Customers = 180;

        final int m3Loss = 20;
        final int m3Customers = 160;

        final float aveLoss = 20f;

        CustomersInfo q = new CustomersInfo(
                currentMonth,
                endOfLastMonth,
                m1Loss,
                m1Customers
        );

        q.addMonth(m2Customers, m2Loss);
        q.addMonth(m3Customers, m3Loss);

        assertEquals(q.getAverageLoss(), aveLoss);
        assertFalse(q.addMonth(m3Customers, m3Loss));

        boolean thrown = false;

        try {
            q.getCustomersDataFor(Month.FEBRUARY);
        } catch (CustomersInfo.MonthNotInDataException e) {
            System.err.println(e);
            thrown = true;
        }
        assertFalse(thrown);
        try {
            q.getCustomersDataFor(Month.NOVEMBER);
        } catch (CustomersInfo.MonthNotInDataException e) {
            System.err.println(e);
            thrown = true;
        }
        assertTrue(thrown);
        thrown = false;
        try {
            q.getCustomersDataFor(Month.MARCH);
        } catch (CustomersInfo.MonthNotInDataException e) {
            System.err.println(e);
            thrown = true;
        }
        assertFalse(thrown);






    }
}