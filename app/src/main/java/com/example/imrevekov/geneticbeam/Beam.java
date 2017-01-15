package com.example.imrevekov.geneticbeam;

/**
 * Created by imre.vekov on 1/14/2017.
 */

public class Beam {
    private String name;
    private int typeA, typeB;
    private double areaVz, wEly, price;


    public Beam(String name, int typeA, int typeB, double areaVz, double wEly, double price) {
        this.name = name;
        this.typeA = typeA;
        this.typeB = typeB;
        this.areaVz = areaVz;
        this.wEly = wEly;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeA() {
        return typeA;
    }

    public void setTypeA(int typeA) {
        this.typeA = typeA;
    }

    public int getTypeB() {
        return typeB;
    }

    public void setTypeB(int typeB) {
        this.typeB = typeB;
    }

    public double getAreaVz() {
        return areaVz;
    }

    public void setAreaVz(double areaVz) {
        this.areaVz = areaVz;
    }

    public double getwEly() {
        return wEly;
    }

    public void setwEly(double wEly) {
        this.wEly = wEly;
    }

    @Override
    public String toString() {
        return "Beam: " + name + " Type: " + typeA + " " + typeB + " AreaVz: " + areaVz + " Wely: " + wEly + " Price: " + price + "\n";
    }
}
