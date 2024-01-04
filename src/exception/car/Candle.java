package exception.car;

import java.util.Random;

public class Candle {
    private boolean isWorking;
    public Candle(){
        Random r = new Random();
        isWorking = r.nextInt(100) > 5;
    }
    public void giveSpark() throws CarException{
        if (!isWorking)
            throw new CarException("Candle doesn't work");
    }
}
