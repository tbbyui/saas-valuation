package com.example.justin.myapplication.controler;

import com.example.justin.myapplication.model.Valuation;

import java.util.List;

public interface ValuationFetcher {
    List<Valuation> getValuations();
    Valuation getValuation();

}
