package com.example.demo;

import java.util.Date;

public class Movement {
    private Date date;
    private String name;
    private double amount;

    public Movement(Date date, String name, double amount) {
        this.date = date;
        this.name = name;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    static Movement[] simulateMovements() {
        Movement[] movements = new Movement[3];
        movements[0] = new Movement(new Date(), "Abonnement", 9.99);
        movements[1] = new Movement(new Date(), "Casserole", 15);
        movements[2] = new Movement(new Date(), "Poele", 10);
        return movements;
    }

    @Override
    public String toString() {
        return date + " " + name + " " + amount +"€";
    }
}
