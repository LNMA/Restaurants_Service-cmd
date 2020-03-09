package com.louay.projects.controller;

import com.louay.projects.entry.DrinksOrder;
import com.louay.projects.entry.Order;
import com.louay.projects.entry.SandwichesOrder;
import com.louay.projects.view.CommandLineInterface;

public class Sequence extends Order {
    protected Order [] sequence  = new Order[3];



    public Sequence() {
    }



    protected void setNewSize() {
        int raw = sequence.length-1 ;
        if (sequence[raw] != null) {
            Order[] newArray = new Order[raw * 2];
            for (int i = 0; i < sequence.length; i++) {
                newArray[i] = sequence[i];
            }
            sequence = newArray;
        }
    }

    protected void setLastID(){
        int lastID = 0 ;
        for (int i = 0;i<sequence.length;i++)
            if (sequence[i] == null) {
                lastID = i;
                break;
            }
        setSequence(lastID);
    }

    protected int freeI(){
        int freeI = 0;
        for (int i = 0; i <sequence.length; i++) {
            if (sequence[i] == null) {
                freeI = i;
                break;
            }
        }
        return freeI;
    }

    protected int idSearching(int id ){
        int indexMatch=-1;
        try {
            for(int i =0;i< sequence.length;i++){
                if (sequence[i] != null){
                    if (sequence[i].getOrderID() == id){
                        indexMatch=i;
                        break;
                    }
                }
            }
            if (indexMatch == -1)
                throw new IllegalArgumentException("\n>> sorry we did not find match id\n");
        }
        catch (IllegalArgumentException e){
            System.out.print(e.getMessage());
            id = idSearching(new CommandLineInterface().inputOrderID());
        }
        return indexMatch;
    }

    protected void setBills(){
        double total =0;
        for (int i =0;i<sequence.length;i++){
            if (sequence[i] != null){
                if (sequence[i] instanceof SandwichesOrder)
                    total += ((SandwichesOrder)sequence[i]).getPricesOfSandwiches();
                else
                    total += ((DrinksOrder)sequence[i]).getPriceOfDrinks();
            }
        }
        setTotalBill(total);
    }
}
