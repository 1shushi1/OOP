package patterns.abstractFactory.game;

public abstract class Gun implements Cloneable{
    protected double calibre;
    protected double speed;
    public Gun(double calibre, double speed){
        this.calibre = calibre;
        this.speed = speed;
    }
    public abstract void shout();
    public abstract Gun clone();
}
