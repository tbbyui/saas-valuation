package com.example.justin.myapplication.model;

public class Revenue {
    private double thisYear;
    private double lastYear;

    public Revenue(double currentRevenue, double revenueLastYear) {
        this.thisYear = currentRevenue;
        this.lastYear = revenueLastYear;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "thisYear=" + thisYear +
                ", lastYear=" + lastYear +
                '}';
    }

    public double getThisYear() {
        return thisYear;
    }

    public void setThisYear(double thisYear) {
        this.thisYear = thisYear;
    }

    public double getLastYear() {
        return lastYear;
    }

    public void setLastYear(double lastYear) {
        this.lastYear = lastYear;
    }

    public double getGrowthPercent() {
        return getThisYear() / getLastYear();
    }
}
