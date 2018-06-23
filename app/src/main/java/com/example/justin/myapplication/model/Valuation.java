package com.example.justin.myapplication.model;

import com.example.justin.myapplication.LoadSave;
import com.example.justin.myapplication.Month;
import com.google.gson.Gson;

public class Valuation {
    CustomersInQuarter customerData;
    RevenueGrowth revenueGrowth;

    public Valuation() {
        customerData = null;
        revenueGrowth = null;
    }

    public boolean valuationIsFull() {
        boolean full = true;
        if (customerData == null) {
            full = false;
        }
        if (revenueGrowth == null) {
            full = false;
        }

        return full;
    }

    public String getJson() {
        Gson g = new Gson();
        return g.toJson(this);
    }

    public CustomersInQuarter getCustomerData() {
        return customerData;
    }

    public void initCustomerData(
            Month currentMonth,
            int endOfLastMonth,
            int lostDuringLastMonth,
            int endOfPrevMonth
    ) {
        this.customerData = new CustomersInQuarter(
                currentMonth,
                endOfLastMonth,
                lostDuringLastMonth,
                endOfPrevMonth
        );
    }

    public boolean addCustomerMonth(int startingCustomers, int lostCustomers) {
        return customerData.addMonth(startingCustomers, lostCustomers);
    }

    public RevenueGrowth getRevenueGrowth() {
        return revenueGrowth;
    }

    public void setRevenueGrowth(double currentRevenue, double revenueLastYear) {
        this.revenueGrowth = null;
        this.revenueGrowth = new RevenueGrowth(currentRevenue, revenueLastYear);
    }
}
