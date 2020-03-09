package com.louay.projects.entry;

import java.io.Serializable;

public class  DrinksOrder extends Order implements Serializable {
    private int numberOfDrinks = 0;
    private double priceOfDrinks = 0;
    private static final double pricePerDrink = 0.5;

    public DrinksOrder(int numberOfDrinks) {
        super();
        this.numberOfDrinks = numberOfDrinks;
        this.priceOfDrinks = numberOfDrinks*pricePerDrink;
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }

    public void setNumberOfDrinks(int numberOfDrinks) {
        this.numberOfDrinks = numberOfDrinks;
        setPriceOfDrinks(numberOfDrinks*pricePerDrink);
    }

    public double getPriceOfDrinks() {
        return priceOfDrinks;
    }

    public void setPriceOfDrinks(double priceOfDrinks) {
        this.priceOfDrinks = priceOfDrinks;
    }

    @Override
    public String toString() {
        if (getNumberOfDrinks() != 0)
            return super.toString()+"DrinksOrder{" +
                    "numberOfDrinks=" + numberOfDrinks +
                    ", priceOfDrinks=" + priceOfDrinks +
                    '}';
        else
            return super.toString();
    }
}
