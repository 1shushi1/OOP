package patterns.abstractFactory.game.usa;

import patterns.abstractFactory.game.Gun;
import patterns.abstractFactory.game.MilitaryFactory;
import patterns.abstractFactory.game.Plane;
import patterns.abstractFactory.game.Tank;

import java.util.Arrays;
import java.util.List;

public class UsaFabric extends MilitaryFactory {
    private List<Tank> tanks = Arrays.asList(new M1_Abrams(80, 13, 109),
            new M1_Abrams(80, 13, 109), new M1_Abrams(80, 13, 109));
    private List<Plane> planes = Arrays.asList(new F18(14, 1600, 450), new F32(20, 2000, 1000),
            new F32(20, 2000, 1000), new F32(20, 2000, 1000), new F18(14, 1600, 450));
    private List<Gun> guns = Arrays.asList(new M142_HIMARS(108, 80), new M142_HIMARS(108, 80), new M142_HIMARS(108, 80));
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
