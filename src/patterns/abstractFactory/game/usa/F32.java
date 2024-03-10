package patterns.abstractFactory.game.usa;

import patterns.abstractFactory.game.Plane;

public class F32 extends Plane {
    public F32(double height, double speed, double shoutDistance){
        super(height, speed, shoutDistance);
    }
    @Override
    public void shout(){
        System.out.println("Shout 2 tomahawk rockets");
    }
    @Override
    public void manever(){
        System.out.println(getClass().getSimpleName() + " is making manever");
    }
    @Override
    public Plane clone(){
        return new F18(height, speed, shoutDistance);
    }
}
