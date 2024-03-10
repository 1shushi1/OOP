package patterns.abstractFactory.game;

public abstract class Plane implements Cloneable{
    protected double height;
    protected double speed;
    protected double shoutDistance;
    public Plane(double height, double speed, double shoutDistance){
        this.height = height;
        this.speed = speed;
        this.shoutDistance = shoutDistance;
    }

    public abstract void shout();

    public abstract void manever();
    public abstract Plane clone();
}
