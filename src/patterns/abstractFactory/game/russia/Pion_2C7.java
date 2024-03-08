package patterns.abstractFactory.game.russia;

import patterns.abstractFactory.game.Gun;

public class Pion_2C7 extends Gun {
    public Pion_2C7(double calibre, double speed){
        super(calibre, speed);
    }
    @Override
    public void shout(){
        System.out.println(getClass().getSimpleName() + " launch rockets");
    }
}
