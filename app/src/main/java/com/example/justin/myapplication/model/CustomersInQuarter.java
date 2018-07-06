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
    private int addCap; // Temp Solution for not knowing the year

    public CustomersInQuarter(
        Month currentMonth,
        int endOfLastMonth,
        int lostDuringLastMonth,
        int endOfPrevMonth
    ) {
        this.currentMonth = currentMonth;
        this.earliestMonth = currentMonth;
        this.custLastMonth = endOfLastMonth;

        this.addCap = 3;

        customersData = new ArrayList<>();
        addMonth(endOfPrevMonth, lostDuringLastMonth);
    }

    public boolean addMonth(int custAtStart, int custLost) {
        if (earliestMonth.getPrevMonth().equals(currentMonth) || addCap <= 0) {
            return false;
        }

        earliestMonth = earliestMonth.getPrevMonth();
        customersData.add(new MonthOfCustomers(earliestMonth, custAtStart, custLost));

        addCap--;
        return true;
    }

    public MonthOfCustomers getCustomersDataFor(Month month) throws MonthNotInDataException {
        for (MonthOfCustomers m : customersData) {
            if (m.getMonth().equals(month)) {
                return m;
            }
        }
        throw new MonthNotInDataException("Month " + month.toString() + " is not in the data list");
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

    public float getEstimatedYearlyChrunRate() {
        return getAverageChurnRate() * 12;
    }

    public float getAverageChurnRate() {
        Integer numOfMonths = 0;
        Float totalChurn = 0f;
        for (MonthOfCustomers m : customersData) {
            totalChurn += m.getChurn();
            numOfMonths++;
        }
        return totalChurn / numOfMonths;
    }

    public float getAverageLoss() {
        int numOfMonths = 0;
        int totalLoss = 0;
        for (MonthOfCustomers m : customersData) {
            totalLoss += m.getLoss();
            numOfMonths++;
        }
        return (float)totalLoss / (float)numOfMonths;
    }

    public float getAverageCustomers() {
        int numOfMonths = 0;
        int totalCustomers = 0;
        for (MonthOfCustomers m : customersData) {
            totalCustomers += m.getCustomers();
            numOfMonths++;
        }
        totalCustomers += custLastMonth;
        numOfMonths++;
        return (float)totalCustomers / (float)numOfMonths;
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

        public int getCustomers() {
            return custAtStart;
        }

        public void setCustomers(int custAtStart) {
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
