package com.industrialmojo.dto;

public class Customer {

    private String name;
    private int points;

    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public boolean hasOverHundredPoints() {
        return this.points > 100;
    }
}
