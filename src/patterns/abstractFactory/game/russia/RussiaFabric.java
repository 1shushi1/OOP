package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Gun;
import patterns.abstractFactory.game.MilitaryFactory;
import patterns.abstractFactory.game.Plane;
import patterns.abstractFactory.game.Tank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RussiaFabric extends MilitaryFactory {
    private Random r = new Random();
    private List<Tank> tanks = Arrays.asList(new T_54(51, 10, 80),
            new T_90(70, 14, 99), new T_90(70, 14, 99));
    private List<Plane> planes = Arrays.asList(new SU27(10, 1500, 200), new MIG_29(15, 1700, 400),
            new MIG_29(14, 1700, 400));
    private List<Gun> guns = Arrays.asList(new Pion_2C7(100, 400), new Pion_2C7(100, 400));


    @Override
    public Tank createTank(){
       return tanks.get(r.nextInt(tanks.size())).clone();
    }
    @Override
    public Plane createPlane(){
        return planes.get(r.nextInt(planes.size())).clone();
    }
    @Override
    public Gun createGun(){
        return guns.get(r.nextInt(guns.size())).clone();
    }
}
