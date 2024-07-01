package patterns.abstractFactory.game;

public abstract class Tank implements Cloneable {
    protected double speed;
    protected double shoutDistance;
    protected double shieldThickness;
    public Tank(double speed, double shoutDistance, double shieldThickness){
        this.speed = speed;
        this.shoutDistance = shoutDistance;
        this.shieldThickness = shieldThickness;
    }
    public abstract void shout();
    public abstract void accelerate();
    public abstract Tank clone();
}
