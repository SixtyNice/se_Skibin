package sef.module9.activity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Radar r = new RadarImpl();
        RadarContact r1 = new RadarContactImpl("R1", 15, 1000);
        RadarContact r2 = new RadarContactImpl("R2", 360, 2000);
        RadarContact r3 = new RadarContactImpl("R3", 180, -3000);

        r.addContact(r1);
        r.addContact(r2);
        r.addContact(r3);

        System.out.println(r.returnContacts(new DistanceComparator()));


    }
}
