package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Tank;

public class T_90 extends Tank {
    public T_90(double speed, double shoutDistance, double shieldThickness){
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
