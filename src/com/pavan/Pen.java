package com.pavan;

import java.util.Comparator;

public class Pen implements Comparable<Pen> {
    private int price;
    private String colour;

    public Pen(int price, String colour) {
        this.price = price;
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public int compareTo(Pen o1) {
        return this.getPrice()==o1.getPrice() ? 0 : ((this.getPrice() > this.getPrice()) ? 1 : -1);
    }

    @Override
    public String toString() {
        return "\n{" +
                "price=" + price +
                ", colour='" + colour + '\'' +
                '}';
    }
}

