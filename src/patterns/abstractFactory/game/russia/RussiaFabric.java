package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Gun;
import patterns.abstractFactory.game.MilitaryFactory;
import patterns.abstractFactory.game.Plane;
import patterns.abstractFactory.game.Tank;

import java.util.Random;

public class RussiaFabric extends MilitaryFactory {
    @Override
    public Tank createTank(){
        Tank tank = null;
        if (r.nextInt(2) == 1){
            tank = new
        }

    }
    @Override
    public Plane createPlane(){

    }
    @Override
    public Gun createGun(){

    }
}
