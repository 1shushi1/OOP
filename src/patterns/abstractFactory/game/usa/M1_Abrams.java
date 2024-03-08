package patterns.abstractFactory.game.usa;

import patterns.abstractFactory.game.Tank;

public class M1_Abrams extends Tank {
    public M1_Abrams(double speed, double shoutDistance, double shieldThickness){
        super(speed, shoutDistance, shieldThickness);
    }
    @Override
    public void shout(){
        System.out.println(getClass().getSimpleName() + " shout");
    }
    @Override
    public void accelerate(){
        System.out.println(getClass().getSimpleName() + " is speeding up");
    }
}
