package com.louay.projects.entry;


import java.io.Serializable;

public class SandwichesOrder extends Order implements Serializable {
    private int numbersOfSandwiches = 0;
    private double pricesOfSandwiches = 0;
    private static final double pricePerSandwich = 1.25;

    public SandwichesOrder(int numbersOfSandwiches) {
        super();
        this.numbersOfSandwiches = numbersOfSandwiches;
        this.pricesOfSandwiches = numbersOfSandwiches*pricePerSandwich;
    }

    public int getNumbersOfSandwiches() {
        return numbersOfSandwiches;
    }

    public void setNumbersOfSandwiches(int numbersOfSandwiches) {
        this.numbersOfSandwiches = numbersOfSandwiches;
        setPricesOfSandwiches(numbersOfSandwiches*pricePerSandwich);
    }

    public double getPricesOfSandwiches() {
        return pricesOfSandwiches;
    }

    public void setPricesOfSandwiches(double pricesOfSandwiches) {
        this.pricesOfSandwiches = pricesOfSandwiches;
    }

    @Override
    public String toString() {
        if (getNumbersOfSandwiches() != 0)
            return super.toString()+"SandwichesOrder{" +
                    "numbersOfSandwiches=" + numbersOfSandwiches +
                    ", pricesOfSandwiches=" + pricesOfSandwiches +
                    '}';
        else
            return super.toString();
    }
}
