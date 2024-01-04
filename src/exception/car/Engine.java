package exception.car;

import java.util.Random;

public class Engine {
    private double fuelConsumptionCarStop = 0.01;
    private double fuelConsumptionAccelerate = 0.1;
    private final int numberOfRevolutions = 2500;
    private int currentNumOfRev;
    private boolean on;
    private boolean isWorkingProperly;
    private Random r = new Random();
    public Engine(){
        isWorkingProperly = (r.nextInt(100) > 5);
    }
    public void addRevolutions(){
        if (on) {
            currentNumOfRev += 200;
        }
    }
    public void start() throws CarException{
        if (!isWorkingProperly)
            throw new CarException("Your engine is not working properly");
        on = true;
        currentNumOfRev = numberOfRevolutions;
    }
    public void decreaseRev(int rev){
        if (on) {
            currentNumOfRev -= rev;
        }
    }
    public double getFuelConsumptionCarStop(){
        return fuelConsumptionCarStop;
    }
    public boolean isOn(){
        return on;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    public int getCurrentNumOfRev(){
        return currentNumOfRev;
    }
}
