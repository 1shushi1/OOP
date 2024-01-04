package statics.enums.car;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car(CarColor.BLACK, CarBrand.BWM, Engine.BMW_G_5M, Transmission.TR_BMW_4_4);
        Car car2 = new Car(CarColor.RED, CarBrand.MINI, Engine.MINI_D_2, Transmission.TR_MINI_3);
        Car car3 = new Car(CarColor.BLUE, CarBrand.ROLLS_ROYCE, Engine.ROLLS_ROYCE_G_6, Transmission.TR_ROLLS_ROYCE_6);
        car1.info();
        car2.info();
        car3.info();
        car1.setEngine(Engine.BMW_D_35);
        car1.info();
        car3.setTransmission(Transmission.TR_ROLLS_ROYCE_8);
        car3.info();
        car2.setEngine(null);
        car2.info();
        Engine [] engines = Engine.values();
        Random r = new Random();
        int pos = r.nextInt(engines.length);
        Engine randomEngine = engines[pos];
        randomEngine.info();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter engine name");
        String findEngine = s.next().toUpperCase();
        Engine engine = Engine.valueOf(findEngine);
        engine.info();
    }
}
