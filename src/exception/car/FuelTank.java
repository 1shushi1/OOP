package exception.car;
import java.util.Random;
public class FuelTank {
    private Pump pump = new Pump();
    private int volume;
    private Random r = new Random();
    public FuelTank(){
        volume = r.nextInt(40);
    }
    public void pump(double fuelCons) throws CarException{
        pump.pumpTheFuel(fuelCons);
    }
    class Pump {
        public void pumpTheFuel(double fuelConsumption) throws CarException{
            if (volume < 5)
                throw new CarException("Not enough fuel");
            volume -= fuelConsumption;
        }
    }
}
