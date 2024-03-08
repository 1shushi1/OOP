package patterns.abstractFactory.game;

import java.util.Random;

public abstract class MilitaryFactory {
    protected Random r = new Random();
    //create tank
    public abstract Tank createTank();
    //create plane
    public abstract Plane createPlane();
    //create gun
    public abstract Gun createGun();

}
