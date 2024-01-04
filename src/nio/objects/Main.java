package nio.objects;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Engine engine1 = new Engine(2.0, 230, 7);
        Engine engine2 = new Engine(3.0, 333, 12);
        Engine engine3 = new Engine(2.5, 350, 8.5);
        Car car1 = new Car(engine1, "Mercedes", "E-Class", 2019, 30498712039487124l);
        Car car2 = new Car(engine2, "Audi", "A6", 2015, 398127348992034l);
        Car car3 = new Car(engine3, "Toyota", "Highlander", 2021, 1902834791283749879l);
        Car car4 = new Car(engine1, "BMW", "3", 2014, 190237091230193l);

//        boolean ans = CarController.save(car1);
//        System.out.println(ans);

//        ArrayList<Car> cars = new ArrayList<>();
//        Collections.addAll(cars, car1, car2, car3, car4);
//
//        boolean ans = CarController.saveAll(cars);
//        System.out.println(ans);

//        boolean ans = CarController.delete(car2);
//        System.out.println(ans);

//        boolean ans = CarController.update(car3, car1);
//        System.out.println(ans);

        ArrayList<Car> cars = CarController.findAll();
        System.out.println(cars);
    }
}
