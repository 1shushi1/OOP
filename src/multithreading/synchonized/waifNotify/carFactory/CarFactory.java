package multithreading.synchonized.waifNotify.carFactory;

import java.io.BufferedWriter;
import java.util.Random;

public class CarFactory extends Thread {
    private String name;
    private BufferedWriter writer;
    private Parking parking;

    public CarFactory(String name, BufferedWriter writer, Parking parking) {
        this.parking = parking;
        this.writer = writer;
        this.name = name;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true) {
            int serNum = r.nextInt(100 - 1) + 1;
            parking.parkCar(new Car(name, serNum));
            try {
                Thread.sleep((r.nextInt(3-1)+1)*1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
