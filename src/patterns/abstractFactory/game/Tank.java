package patterns.abstractFactory.game;

public abstract class Tank {
    private double speed;
    private double shoutDistance;
    private double shieldThickness;
    public Tank(double speed, double shoutDistance, double shieldThickness){
        this.speed =speed;
        this.shoutDistance = shoutDistance;
        this.shieldThickness = shieldThickness;
    }
    public abstract void shout();
    public abstract void accelerate();
}
