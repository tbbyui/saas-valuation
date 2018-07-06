package com.example.justin.myapplication;

import com.example.justin.myapplication.model.Valuation;

import org.junit.Test;

public class ValuationTest {
    @Test
    public void toJsonTest() {
        Valuation v = new Valuation();
        System.out.println(v.getJson());
        v.setRevenueGrowth(123.32, 12432.24);
        System.out.println(v.getJson());
        v.initCustomerData(Month.APRIL,150,30, 100);
        System.out.println(v.getJson());
        v.addCustomerMonth(120, 20);
        System.out.println(v.getJson());

    }
}
