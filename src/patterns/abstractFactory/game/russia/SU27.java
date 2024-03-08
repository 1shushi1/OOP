package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Plane;

public class SU27 extends Plane {
    public SU27(double height, double speed, double shoutDistance){
        super(height, speed, shoutDistance);
    }
    @Override
    public void shout(){
        System.out.println("Shout 2 rockets");
    }
    @Override
    public void manever(){
        System.out.println(getClass().getSimpleName() + " is making manever");
    }
}
