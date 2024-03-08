package patterns.abstractFactory.game;

public abstract class Gun {
    private double calibre;
    private double speed;
    public Gun(double calibre, double speed){
        this.calibre = calibre;
        this.speed = speed;
    }
    public abstract void shout();
}
