package patterns.abstractFactory.game.usa;

import patterns.abstractFactory.game.Gun;

public class M142_HIMARS extends Gun {
    public M142_HIMARS(double calibre, double speed){
        super(calibre, speed);
    }
    @Override
    public void shout(){
        System.out.println(getClass().getSimpleName() + " launch rockets");
    }
    @Override
    public Gun clone(){
        return new M142_HIMARS(calibre, speed);
    }
}
