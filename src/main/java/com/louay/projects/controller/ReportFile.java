package com.louay.projects.controller;


import com.louay.projects.entry.DrinksOrder;
import com.louay.projects.entry.SandwichesOrder;
import com.louay.projects.io.IOOut;

public class ReportFile extends Sequence {
    private double total;
    private double totalNumberOfOrder;


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalNumberOfOrder() {
        return totalNumberOfOrder;
    }

    public void setTotalNumberOfOrder(double totalNumberOfOrder) {
        this.totalNumberOfOrder = totalNumberOfOrder;
    }

    protected void totalBills(){
        double total =0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder)
                    total += ((SandwichesOrder)sequence[i]).getPricesOfSandwiches();
                else
                    total += ((DrinksOrder)sequence[i]).getPriceOfDrinks();
            }
        }
        IOOut.writeReport("\n>> The sum of total bills is> ",total);
        IOOut.writeReport("\n>> Average cost per order is> ",(total/getTotalNumberOfOrder()));
        setTotal(total);
    }

    protected void numberOfOrder(){
        double drink = 0 ;
        double sandwiches = 0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder)
                    sandwiches ++;
                else
                    drink ++;
            }
        }
        IOOut.writeReport("\n>> The number of all drink order was> ",drink);
        IOOut.writeReport("\n>> The number of all sandwiches order was> ",sandwiches);
        setTotalNumberOfOrder(drink+sandwiches);
    }

    protected void numberOfSoldItem(){
        double drink = 0 ;
        double sandwiches = 0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder)
                    sandwiches += ((SandwichesOrder)sequence[i]).getNumbersOfSandwiches();
                else
                    drink += ((DrinksOrder)sequence[i]).getNumberOfDrinks();
            }
        }
        IOOut.writeReport("\n>> The number of drinks sold was> ",drink);
        IOOut.writeReport("\n>> The number of sandwiches sold was> ",sandwiches);
    }

    protected void maxOrder(){
        double maxSandwich = 0;
        int idSandwich = 0;
        double tempSandwich =0;
        double maxDrink =0;
        int idDrink = 0;
        double tempDrink =0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder) {
                    tempSandwich = ((SandwichesOrder) sequence[i]).getPricesOfSandwiches();
                    if (tempSandwich > maxSandwich) {
                        maxSandwich = tempSandwich;
                        idSandwich = sequence[i].getOrderID();
                    }
                }else {
                    tempDrink = ((DrinksOrder) sequence[i]).getPriceOfDrinks();
                    if (tempDrink > maxDrink){
                        maxDrink = tempDrink;
                        idDrink = sequence[i].getOrderID();
                    }
                }
            }
        }
        IOOut.writeReport("\n>> the maximum Sandwich order cost was > OrderID> ",idSandwich);
        IOOut.writeReport("\n>> the maximum Sandwich order cost was > Cost> ",maxSandwich);
        IOOut.writeReport("\n>> the maximum Drink order cost was > OrderID> ",idDrink);
        IOOut.writeReport("\n>> the maximum Drink order cost was > Cost> ",maxDrink);
    }

    protected void minOrder(){
        double minSandwich = 0;
        int idSandwich = 0;
        double tempSandwich =0;
        double minDrink =0;
        int idDrink = 0;
        double tempDrink =0;
        for (int i = 0; i<sequence.length;i++){
            if (sequence[i] instanceof SandwichesOrder){
                minSandwich = ((SandwichesOrder) sequence[i]).getPricesOfSandwiches();
                idSandwich = sequence[i].getOrderID();
                if (minSandwich != 0 )
                    break;
            }
        }
        for (int i = 0; i<sequence.length;i++){
            if (sequence[i] instanceof DrinksOrder){
                minDrink = ((DrinksOrder) sequence[i]).getPriceOfDrinks();
                idDrink = sequence[i].getOrderID();
                if (minDrink != 0 )
                    break;
            }
        }
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder) {
                    tempSandwich = ((SandwichesOrder) sequence[i]).getPricesOfSandwiches();
                    if (tempSandwich < minSandwich) {
                        minSandwich = tempSandwich;
                        idSandwich = sequence[i].getOrderID();
                    }
                }else {
                    tempDrink = ((DrinksOrder) sequence[i]).getPriceOfDrinks();
                    if (tempDrink < minDrink){
                        minDrink = tempDrink;
                        idDrink = sequence[i].getOrderID();
                    }
                }
            }
        }
        IOOut.writeReport("\n>> the minimum Sandwich order cost was > OrderID> ",idSandwich);
        IOOut.writeReport("\n>> the minimum Sandwich order cost was > Cost> ",minSandwich);
        IOOut.writeReport("\n>> the minimum Drink order cost was > OrderID> ",idDrink);
        IOOut.writeReport("\n>> the minimum Drink order cost was > Cost> ",minDrink);
    }

    protected void upperAverage(){
        double average = getTotal()/getTotalNumberOfOrder();
        double count = 0;
        double tempSandwich =0;
        double tempDrink =0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder) {
                    tempSandwich = ((SandwichesOrder) sequence[i]).getPricesOfSandwiches();
                    if (tempSandwich >= average) {
                        count++;
                    }
                }else {
                    tempDrink = ((DrinksOrder) sequence[i]).getPriceOfDrinks();
                    if (tempDrink >= average){
                        count++;
                    }
                }
            }
        }
        IOOut.writeReport("\n>> The number of orders with cost above or equal average > ",count);
        IOOut.writeReport("\n>> Average cost is> ",average);
    }
}
