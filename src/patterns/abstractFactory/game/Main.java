package patterns.abstractFactory.game;

import patterns.abstractFactory.game.russia.RussiaFabric;
import patterns.abstractFactory.game.usa.UsaFabric;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MilitaryFactory usaFabric = new UsaFabric();
        MilitaryFactory russiaFabric = new RussiaFabric();


        List<Tank> tanks = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();
        List<Gun> guns = new ArrayList<>();

        List<Tank> tanks1 = new ArrayList<>();
        List<Plane> planes1 = new ArrayList<>();
        List<Gun> guns1 = new ArrayList<>();

        for (int i = 0; i < 5 ; i++) {
            tanks.add(usaFabric.createTank());
        }
        for (int i = 0; i < 3 ; i++) {
            planes.add(usaFabric.createPlane());
        }
        for (int i = 0; i < 4 ; i++) {
            guns.add(usaFabric.createGun());
        }

        for (int i = 0; i < 3 ; i++) {
            tanks1.add(russiaFabric.createTank());
        }
        for (int i = 0; i < 4 ; i++) {
            planes1.add(russiaFabric.createPlane());
        }
        for (int i = 0; i < 2 ; i++) {
            guns1.add(russiaFabric.createGun());
        }

        tanks.forEach(e -> e.shout());

        tanks1.forEach(e -> e.shout());

        planes.forEach(e -> e.manever());

        planes1.forEach(e -> e.manever());

        guns.forEach(e -> e.shout());

        guns1.forEach(e -> e.shout());
    }
}
