package com.example.imrevekov.geneticbeam;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by imre.vekov on 1/15/2017.
 */

public class Archive {


    ArrayList<Setup> setups;
    Setup bestSetup = null;

    public Archive() {
        setups = new ArrayList<Setup>();
    }


    public void clearSetups(){
        setups.clear();
    }

    public ArrayList<Setup> getSetups() {
        return setups;
    }

    public boolean insertSetupIntoArchive(Setup newSetup) {
        boolean insertedFlag = true;
        for (Iterator<Setup> iterator = setups.iterator(); iterator.hasNext(); ) {
            Setup tempSetup = iterator.next();

            if (Archive.dominates(tempSetup, newSetup)) {
                insertedFlag = false;
            }
            if (Archive.dominates(newSetup, tempSetup)) {
                iterator.remove();
            }
        }
        if (insertedFlag == true) {
            setups.add(newSetup);
        }
        return insertedFlag;
    }


    public static boolean dominates(Setup a, Setup b) {
        if ((a.beam.getwEly() <= b.beam.getwEly()) && (a.getOpenings() <= b.getOpenings())) {
            return true;
        } else {
            return false;
        }
    }

    public Setup bestSetupFromArchive() {
        if (setups.size() != 0) {
            bestSetup = setups.get(0);
        }
        for (int i = 0; i < setups.size(); i++) {
            if (bestSetup.getTotalPrice() > setups.get(i).getTotalPrice()) {
                bestSetup = setups.get(i);
            }
        }
        return bestSetup;
    }
}
