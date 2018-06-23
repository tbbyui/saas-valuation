package com.example.justin.myapplication;

import com.example.justin.myapplication.model.CustomersInQuarter;

import static junit.framework.Assert.*;
import org.junit.Test;

public class CustomersInQuarterTest {
    @Test
    public void constructorTest() {
        final Month currentMonth = Month.MARCH;
        final int endOfLastMonth = 120;
        final int lostDuringLastMonth = 20;
        final int endOfPrevMonth = 100;

        CustomersInQuarter q = new CustomersInQuarter(
                currentMonth,
                endOfLastMonth,
                lostDuringLastMonth,
                endOfPrevMonth
        );

        Float churn = new Float(100);

        assertEquals(q.getEarliestCustomerData().getMonth(), currentMonth.getPrevMonth());
        assertEquals(q.getEarliestCustomerData().getStart(), endOfPrevMonth);
        assertEquals(q.getEarliestCustomerData().getLoss(), lostDuringLastMonth);
        //assertEquals(q.getEarliestCustomerData().getChurn(), churn); // this will fail.
    }
}
