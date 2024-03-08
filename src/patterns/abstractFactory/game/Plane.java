package patterns.abstractFactory.game;

public abstract class Plane {
    private double height;
    private double speed;
    private double shoutDistance;
    public Plane(double height, double speed, double shoutDistance){
        this.height = height;
        this.speed = speed;
        this.shoutDistance = shoutDistance;
    }

    public abstract void shout();

    public abstract void manever();
}
