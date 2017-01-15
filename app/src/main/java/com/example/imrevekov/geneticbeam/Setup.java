package com.example.imrevekov.geneticbeam;

import android.util.Log;

import java.util.Random;

/**
 * Created by imre.vekov on 1/14/2017.
 */

public class Setup {
    double totalLength, beamLength, distributedForce;


    int openings;


    int typeA;
    int typeB;
    Beams beams;
    Beam beam;
    boolean allRight = false;
    double totalPrice = 0.00;
    double moment, shear, sigma, tau;
    double columnPrice = 10.00;

    public int getTypeA() {
        return typeA;
    }

    public int getTypeB() {
        return typeB;
    }

    public void setOpenings(int openings) {
        this.openings = openings;
    }

    public void setTypeA(int typeA) {
        this.typeA = typeA;
    }

    public void setTypeB(int typeB) {
        this.typeB = typeB;
    }


    public static Setup getRandomSetup(double totalLengthRand, double distributedForceRand) {
        Random ran = new Random();
        int a = ran.nextInt(8);
        int b = ran.nextInt(5);
        int c = ran.nextInt(8);

        return new Setup(totalLengthRand, distributedForceRand, a + 1, b + 1, c + 1);
    }


    @Override
    public String toString() {
        return "Setup: " + "\n" + "Total length: " + totalLength + " Beam length: " + beamLength + "\n" + "Distributed force: " + distributedForce +
                " Openings: " + openings + "\n" + "Beam: " + beam + "Total price: " + getTotalPrice() + "\n";
    }


    public int getOpenings() {
        return openings;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean getAllRight() {
        return allRight;
    }


    public Setup(double totalLength, double distributedForce, int openings, int typeA, int typeB) {
        this.totalLength = totalLength;
        this.distributedForce = distributedForce;
        this.openings = openings;
        this.typeA = typeA;
        this.typeB = typeB;
        beams = new Beams();
        beamLength = totalLength / openings;
        beam = beams.getBeams().get(typeA * 10 + typeB);
        Log.d("beam in setup", beam + "");
        calculate();
    }

    public void calculate() {
        Log.d("shear: ", "*****************CALCULATION " + beam.getName() + " **************************");
        shear = calculateT();
        Log.d("shear: ", shear + "");
        moment = calculateM();
        Log.d("moment: ", moment + "");
        sigma = calculateSigma();
        Log.d("sigma: ", sigma + "");
        tau = calculateTau();
        Log.d("tau: ", tau + "");
        totalPrice = calculateTotalPrice();
        Log.d("total price: ", totalPrice + "");
        allRight = isBeamAllRight();
        Log.d("all right? ", allRight + "");

        Log.d("shear: ", "*****************CALCULATION END " + beam.getName() + " **************************");
    }

    private boolean isBeamAllRight() {
        if ((tau < 225 && (sigma < 225))) {
            return true;
        } else {
            return false;
        }

    }


    public double calculateT() {
        return beamLength * distributedForce / 2;
    }

    public double calculateM() {
        return distributedForce * beamLength * beamLength / 8;
    }

    public double calculateSigma() {
        return moment / beam.getwEly();
    }

    public double calculateTau() {
        return shear / beam.getAreaVz();
    }

    public double calculateTotalPrice() {
        return beam.getPrice() * totalLength / 1000 + (openings - 1) * columnPrice;
    }

    public void crossoverSetup(){

    }


    public void mutateSetup() {
        Random ran = new Random();
        int a = ran.nextInt(3);
        int b = ran.nextInt(2);

        if (a == 0) {
            if ((openings<8)&&(b==0)) {
                setOpenings(getOpenings()+1);
            }

            if ((openings>1)&&(b==1)) {
                setOpenings(getOpenings()-1);
            }
        }

        if (a == 1) {
            if ((typeA<5)&&(b==0)) {
                setTypeA(getTypeA()+1);
            }

            if ((typeA>1)&&(b==1)) {
                setTypeA(getTypeA()-1);
            }
        }

        if (a == 2) {
            if ((typeB<8)&&(b==0)) {
                setTypeB(getTypeB()+1);
            }

            if ((typeB>1)&&(b==1)) {
                setTypeB(getTypeB()-1);
            }
        }
    }
}
