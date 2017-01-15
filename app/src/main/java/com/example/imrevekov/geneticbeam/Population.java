package com.example.imrevekov.geneticbeam;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by imre.vekov on 1/15/2017.
 */

public class Population {
    Setup crossoverSetupA;
    Setup crossoverSetupB;
    ArrayList<Setup> populationOfSetups;

    public ArrayList<Setup> getPopulationOfSetups() {
        return populationOfSetups;
    }

    public Population(double totalLength, double distributedForce, int size) {
        populationOfSetups = new ArrayList<Setup>();
        for (int i = 0; i < size; i++) {
            populationOfSetups.add(Setup.getRandomSetup(totalLength, distributedForce));
        }
    }

    public void mutatePopulation() {
        Random ran = new Random();
        for (int i = 0; i < populationOfSetups.size(); i++) {
            int a = ran.nextInt(5);
            if (a == 0) {
                populationOfSetups.get(i).mutateSetup();
            }
        }
    }

    public void crossoverPopulation() {
        Random ran = new Random();
        for (int i = 0; i + 1 < populationOfSetups.size(); i++) {
            int a = ran.nextInt(10);
            if ((a == 0) && (i < populationOfSetups.size())) {
                crossoverSetupA = populationOfSetups.get(i);
                crossoverSetupB = populationOfSetups.get(i + 1);

                crossoverSetups(crossoverSetupA, crossoverSetupB);

                populationOfSetups.set(i, crossoverSetupA);
                populationOfSetups.set(i+1, crossoverSetupB);
            }
        }
    }

    private void crossoverSetups(Setup crossoverSetupA, Setup crossoverSetupB) {
        Random ran = new Random();
        int a = ran.nextInt(3);
        int temp;
        if (a == 0) {
            temp = crossoverSetupA.getOpenings();
            crossoverSetupA.setOpenings(crossoverSetupB.getOpenings());
            crossoverSetupB.setOpenings(temp);
        }

        if (a == 1) {
            temp = crossoverSetupA.getTypeA();
            crossoverSetupA.setTypeA(crossoverSetupB.getTypeA());
            crossoverSetupB.setTypeA(temp);
        }

        if (a == 2) {
            temp = crossoverSetupA.getTypeB();
            crossoverSetupA.setTypeB(crossoverSetupB.getTypeB());
            crossoverSetupB.setTypeB(temp);
        }


    }


}
