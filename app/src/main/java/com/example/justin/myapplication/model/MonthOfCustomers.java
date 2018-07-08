package com.example.justin.myapplication.model;



import com.example.justin.myapplication.Month;
import com.example.justin.myapplication.Year;


public class MonthOfCustomers {
    private Month month;
    private Year year;
    private int custAtStart;
    private int custLost;

    public MonthOfCustomers(Month month, Year year, int custAtStart, int custLost) {
        this.month = month;
        this.year = year;
        this.custAtStart = custAtStart;
        this.custLost = custLost;
    }

    public Year getYear() {
        return  year;
    }

    public void setYear(Year year) {
        this.year = year;
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
