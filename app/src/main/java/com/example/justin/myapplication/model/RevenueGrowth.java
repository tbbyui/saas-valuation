package com.example.justin.myapplication.model;

public class RevenueGrowth {
    private double currentRevenue;
    private double revenueLastYear;

    public RevenueGrowth(double currentRevenue, double revenueLastYear) {
        this.currentRevenue = currentRevenue;
        this.revenueLastYear = revenueLastYear;
    }

    public double getCurrentRevenue() {
        return currentRevenue;
    }

    public void setCurrentRevenue(double currentRevenue) {
        this.currentRevenue = currentRevenue;
    }

    public double getRevenueLastYear() {
        return revenueLastYear;
    }

    public void setRevenueLastYear(double revenueLastYear) {
        this.revenueLastYear = revenueLastYear;
    }

    public double getGrowthPercent() {
        return getCurrentRevenue() / getRevenueLastYear();
    }
}
