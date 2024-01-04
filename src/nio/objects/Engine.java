package nio.objects;

import java.io.Serializable;

public class Engine implements Serializable {
    private double volume;
    private int horsePowers;
    private double fuelConsumption;

    public Engine(double volume, int horsePowers, double fuelConsumption){
        this.volume = volume;
        this.horsePowers = horsePowers;
        this.fuelConsumption = fuelConsumption;
    }
    public double getVolume(){
        return volume;
    }
    public int getHorsePowers(){
        return horsePowers;
    }
    public double getFuelConsumption(){
        return fuelConsumption;
    }
}
