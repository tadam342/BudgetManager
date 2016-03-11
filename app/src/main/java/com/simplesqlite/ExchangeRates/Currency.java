package com.simplesqlite.ExchangeRates;

import java.io.Serializable;

/**
 * Created by fff on 12.12.2015.
 */
public class Currency implements Serializable {

    private double currencyFirst;
    private double currencySecond;

    public Currency(double currencyFirst, double currencySecond){
        this.currencyFirst = currencyFirst;
        this.currencySecond = currencySecond;
    }

    public Currency(){

    }

    public double getCurrencyFirst() {
        return currencyFirst;
    }

    public void setCurrencyFirst(double currencyFirst) {
        this.currencyFirst = currencyFirst;
    }

    public double getCurrencySecond() {
        return currencySecond;
    }

    public void setCurrencySecond(double currencySecond) {
        this.currencySecond = currencySecond;
    }
}
