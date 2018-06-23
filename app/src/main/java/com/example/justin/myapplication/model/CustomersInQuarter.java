package com.example.justin.myapplication.model;


import com.example.justin.myapplication.Month;

import java.util.ArrayList;
import java.util.List;

/*
* @author   Tristan Barrow<bar16041@byui.edu>
* @version  1.0
* */

public class CustomersInQuarter {
    final private Month currentMonth;
    private Month earliestMonth;
    private int custLastMonth;
    List<MonthOfCustomers> customersData;
    /**
     * Non-Default Constructor                                  (1)
     * <p>
     * This will store
     * <p>                                                      (2)
     * And even more explanations to follow in consecutive
     * paragraphs separated by HTML paragraph breaks.
     *
     * @param  variable Description text text text.             (3)
     * @return Description text text text.
     */
    public CustomersInQuarter(
        Month currentMonth,
        int endOfLastMonth,
        int lostDuringLastMonth,
        int endOfPrevMonth
    ) {
        this.currentMonth = currentMonth;
        this.earliestMonth = currentMonth;
        this.custLastMonth = endOfLastMonth;

        customersData = new ArrayList<>();
        addMonth(endOfPrevMonth, lostDuringLastMonth);
    }

    public boolean addMonth(int custAtStart, int custLost) {
        if (earliestMonth.getPrevMonth().equals(currentMonth)) {
            return false;
        }
        earliestMonth = earliestMonth.getPrevMonth();
        customersData.add(new MonthOfCustomers(earliestMonth, custAtStart, custLost));
        return true;
    }

    public MonthOfCustomers getCustomersDataFor(Month month) throws MonthNotInDataException {
        for (MonthOfCustomers m : customersData) {
            if (m.getMonth().equals(month)) {
                return m;
            }
        }
        throw new MonthNotInDataException("Month " + month.toString() + " is not in the data");
    }

    public MonthOfCustomers getEarliestCustomerData() {
        MonthOfCustomers m = null;
        try {
            m = getCustomersDataFor(earliestMonth);
        } catch (MonthNotInDataException e) {
            System.err.println(e);
        }
        return m;
    }

    public float estimatedYearlyChrun() {
        return 0f;
    }

    public float getAverageChurn() {
        Integer numOfMonths = 0;
        Float totalChurn = 0f;
        for (MonthOfCustomers m : customersData) {
            totalChurn += m.getChurn();
            numOfMonths++;
        }
        return totalChurn / numOfMonths;
    }


    public class MonthOfCustomers {
        private Month month;
        private int custAtStart;
        private int custLost;

        public MonthOfCustomers(Month month, int custAtStart, int custLost) {
            this.month = month;
            this.custAtStart = custAtStart;
            this.custLost = custLost;
        }

        public Month getMonth() {
            return month;
        }

        public void setMonth(Month month) {
            this.month = month;
        }

        public int getStart() {
            return custAtStart;
        }

        public void setStart(int custAtStart) {
            this.custAtStart = custAtStart;
        }

        public int getLoss() {
            return custLost;
        }

        public void setLoss(int custLost) {
            this.custLost = custLost;
        }

        public float getChurn() {
            float custLostf = (float)custLost;
            float custAtStartf = (float)custAtStart;
            return custLostf / custAtStartf;
        }
    }


    public class MonthNotInDataException extends Exception {
        public MonthNotInDataException(String message) {
            super(message);
        }
    }
}
