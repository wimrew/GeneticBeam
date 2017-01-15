package com.example.imrevekov.geneticbeam;

import java.util.HashMap;

/**
 * Created by imre.vekov on 1/14/2017.
 */

public class Beams {
    Beam beam;

    public HashMap<Integer, Beam> getBeams() {
        return beams;
    }

    HashMap<Integer, Beam> beams;

    public Beams() {
        beams = new HashMap<Integer, Beam>();
        generateBeams();
    }

    private void generateBeams() {
        //IPE beams
        beam = new Beam("IPE100", 1, 1, 5.08 * 100, 34.2 * 1000, 100);
        beams.put(11, beam);
        beam = new Beam("IPE120", 1, 2, 6.31 * 100, 53 * 1000, 110);
        beams.put(12, beam);
        beam = new Beam("IPE140", 1, 3, 7.64 * 100, 77.3 * 1000, 120);
        beams.put(13, beam);
        beam = new Beam("IPE160", 1, 4, 9.66 * 100, 109 * 1000, 130);
        beams.put(14, beam);
        beam = new Beam("IPE180", 1, 5, 11.3 * 100, 165 * 1000, 140);
        beams.put(15, beam);
        beam = new Beam("IPE200", 1, 6, 14.0 * 100, 194 * 1000, 150);
        beams.put(16, beam);
        beam = new Beam("IPE220", 1, 7, 15.9 * 100, 252 * 1000, 160);
        beams.put(17, beam);
        beam = new Beam("IPE240", 1, 8, 19.1 * 100, 324 * 1000, 170);
        beams.put(18, beam);

        //IPN beams
        beam = new Beam("IPN100", 2, 1, 4.85 * 100, 34.21 * 1000, 105);
        beams.put(21, beam);
        beam = new Beam("IPN120", 2, 2, 6.63 * 100, 54.7 * 1000, 115);
        beams.put(22, beam);
        beam = new Beam("IPN140", 2, 3, 8.86 * 100, 81.9 * 1000, 125);
        beams.put(23, beam);
        beam = new Beam("IPN160", 2, 4, 10.83 * 100, 117 * 1000, 135);
        beams.put(24, beam);
        beam = new Beam("IPN180", 2, 5, 13.35 * 100, 161 * 1000, 139);
        beams.put(25, beam);
        beam = new Beam("IPN200", 2, 6, 16.03 * 100, 214 * 1000, 155);
        beams.put(26, beam);
        beam = new Beam("IPN220", 2, 7, 19.06 * 100, 278 * 1000, 165);
        beams.put(27, beam);
        beam = new Beam("IPN240", 2, 8, 22.33 * 100, 354 * 1000, 175);
        beams.put(28, beam);

        //HEA beams
        beam = new Beam("HEA100", 3, 1, 7.56 * 100, 72.76 * 1000, 123);
        beams.put(31, beam);
        beam = new Beam("HEA120", 3, 2, 8.46 * 100, 106.3 * 1000, 132);
        beams.put(32, beam);
        beam = new Beam("HEA140", 3, 3, 10.12 * 100, 155.4 * 1000, 137);
        beams.put(33, beam);
        beam = new Beam("HEA160", 3, 4, 13.21 * 100, 220.1 * 1000, 158);
        beams.put(34, beam);
        beam = new Beam("HEA180", 3, 5, 14.47 * 100, 293.6 * 1000, 168);
        beams.put(35, beam);
        beam = new Beam("HEA200", 3, 6, 18.08 * 100, 388.6 * 1000, 180);
        beams.put(36, beam);
        beam = new Beam("HEA220", 3, 7, 20.67 * 100, 515.2 * 1000, 190);
        beams.put(37, beam);
        beam = new Beam("HEA240", 3, 8, 25.18 * 100, 675.1 * 1000, 200);
        beams.put(38, beam);

        //HEB beams
        beam = new Beam("HEB100", 4, 1, 9.04 * 100, 88.91 * 1000, 129);
        beams.put(41, beam);
        beam = new Beam("HEB120", 4, 2, 10.96 * 100, 144.1 * 1000, 136);
        beams.put(42, beam);
        beam = new Beam("HEB140", 4, 3, 13.08 * 100, 215.6 * 1000, 157);
        beams.put(43, beam);
        beam = new Beam("HEB160", 4, 4, 17.56 * 100, 311.5 * 1000, 169);
        beams.put(44, beam);
        beam = new Beam("HEB180", 4, 5, 20.24 * 100, 425.7 * 1000, 185);
        beams.put(45, beam);
        beam = new Beam("HEB200", 4, 6, 24.83 * 100, 569.6 * 1000, 195);
        beams.put(46, beam);
        beam = new Beam("HEB220", 4, 7, 27.92 * 100, 735.5 * 1000, 210);
        beams.put(47, beam);
        beam = new Beam("HEB240", 4, 8, 33.23 * 100, 938.3 * 1000, 220);
        beams.put(48, beam);

        //HEM beams
        beam = new Beam("HEM100", 5, 1, 18.04 * 100, 190.4 * 1000, 156);
        beams.put(51, beam);
        beam = new Beam("HEM120", 5, 2, 21.15 * 100, 288.2 * 1000, 167);
        beams.put(52, beam);
        beam = new Beam("HEM140", 5, 3, 24.46 * 100, 411.4 * 1000, 184);
        beams.put(53, beam);
        beam = new Beam("HEM160", 5, 4, 30.81 * 100, 566.5 * 1000, 194);
        beams.put(54, beam);
        beam = new Beam("HEM180", 5, 5, 34.65 * 100, 748.3 * 1000, 212);
        beams.put(55, beam);
        beam = new Beam("HEM200", 5, 6, 41.03 * 100, 967.4 * 1000, 225);
        beams.put(56, beam);
        beam = new Beam("HEM220", 5, 7, 45.31 * 100, 1217 * 1000, 230);
        beams.put(57, beam);
        beam = new Beam("HEM240", 5, 8, 60.07 * 100, 1799 * 1000, 240);
        beams.put(58, beam);
    }
}
