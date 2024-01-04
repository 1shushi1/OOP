package statics.planetarium;

import java.util.ArrayList;
import java.util.Collections;

public class Planetarium {
    private static final ArrayList<String> planets = new ArrayList<>();
    private String name;
    private String location;
    private double ticketPrice;
    static {
        Collections.addAll(planets, "Earth", "Moon", "Sun", "Pluto", "Saturn", "Jupiter", "Mars", "Mercury");
    }
    public Planetarium(String name, String location, double ticketPrice){
        this.name = name;
        this.location = location;
        this.ticketPrice = ticketPrice;
    }
    public void print(){
        System.out.println("Planetarium : " + name + ". It is located in " + location + ". Entrance price is " + ticketPrice);
        for (int i = 0; i < planets.size(); i++) {
            System.out.print(planets.get(i) + " ");
        }
        System.out.println();
    }
}
