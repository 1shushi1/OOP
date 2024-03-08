package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Plane;

public class MIG_29 extends Plane {
    public MIG_29(double height, double speed, double shoutDistance){
        super(height, speed, shoutDistance);
    }
    @Override
    public void shout(){
        System.out.println("Shout with canon");
    }
    @Override
    public void manever(){
        System.out.println(getClass().getSimpleName() + " is making manever");
    }
}
