package com.louay.projects.entry;

import com.louay.projects.io.IOOut;

import java.io.Serializable;

public class Order implements Serializable {
    private int orderID ;
    private double totalBill;
    private static int sequence;

    public Order() {
        setOrderID(++sequence);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Order.sequence = sequence;
    }

    @Override
    public String toString() {
        if (getTotalBill() == 0)
            return"Order{" +
                    "orderID=" + orderID +
                    '}';
        else
            return "Order{" +
                    "orderID=" + orderID +
                    ", totalBill=" + totalBill +
                    '}';
    }
}
