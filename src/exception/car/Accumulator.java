package exception.car;
import java.util.Random;

public class Accumulator {
    private int capacity;
    private Random r = new Random();
    public Accumulator(){
        capacity = r.nextInt(100);
    }
    public void giveElCurrent() throws CarException{
        if (capacity < 3)
            throw new CarException("Low battery current");
        System.out.println("Accumulator is connected");
    }
}
