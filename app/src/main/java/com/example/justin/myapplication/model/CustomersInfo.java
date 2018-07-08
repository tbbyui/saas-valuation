package com.example.justin.myapplication.model;

import com.example.justin.myapplication.Month;
import com.example.justin.myapplication.Year;

import java.util.ArrayList;
import java.util.List;

/*
* @author   Tristan Barrow<bar16041@byui.edu>
* @version  1.0
* */

public class CustomersInfo {
    List<MonthOfCustomers> customersData;

    public CustomersInfo() {}

    public void addMonth(Month month, Year year, int custAtStart, int custLost) {
        customersData.add(new MonthOfCustomers(month, year, custAtStart, custLost));
    }

    public MonthOfCustomers getCustomersDataFor(Month month) throws MonthNotInDataException {
        for (MonthOfCustomers m : customersData) {
            if (m.getMonth().equals(month)) {
                return m;
            }
        }
        throw new MonthNotInDataException("Month " + month.toString() + " is not in the data list");
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
        numOfMonths++;
        return (float)totalCustomers / (float)numOfMonths;
    }

    public class MonthNotInDataException extends Exception {
        public MonthNotInDataException(String message) {
            super(message);
        }
    }
}
