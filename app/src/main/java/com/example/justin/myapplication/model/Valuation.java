package com.example.justin.myapplication.model;

import com.example.justin.myapplication.LoadSave;
import com.example.justin.myapplication.Month;
import com.google.gson.Gson;

public class Valuation {
    private double publicMultiple;
    private double privateDiscount;
    private double marketingCost;
    private double subscriptionPrice;
    private long tam;
    private Revenue revenueObj;
    private CustomersInfo customers;

    public double getMarketingCost() {
        return marketingCost;
    }

    public void setMarketingCost(double marketingCost) {
        this.marketingCost = marketingCost;
    }

    public double getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public double getPublicMultiple() {
        return publicMultiple;
    }

    public void setPublicMultiple(double publicMultiple) {
        this.publicMultiple = publicMultiple;
    }

    public double getPrivateDiscount() {
        return privateDiscount;
    }

    public void setPrivateDiscount(double privateDiscount) {
        this.privateDiscount = privateDiscount;
    }

    public long getTam() {
        return tam;
    }

    public void setTam(long tam) {
        this.tam = tam;
    }

    public Revenue getRevenueObj() {
        return revenueObj;
    }

    public void setRevenueObj(Revenue revenueObj) {
        this.revenueObj = revenueObj;
    }

    public CustomersInfo getCustomers() {
        return customers;
    }

    public void setCustomers(CustomersInfo customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
