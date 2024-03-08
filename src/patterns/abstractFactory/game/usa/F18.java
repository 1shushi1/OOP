package patterns.abstractFactory.game.usa;

import patterns.abstractFactory.game.Plane;

public class F18 extends Plane{
    public F18(double height, double speed, double shoutDistance){
        super(height, speed, shoutDistance);
    }
    @Override
    public void shout(){
        System.out.println("Shout with mini-gun");
    }
    @Override
    public void manever(){
        System.out.println(getClass().getSimpleName() + " is making manever");
    }
}
