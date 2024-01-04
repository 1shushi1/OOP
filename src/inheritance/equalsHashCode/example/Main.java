package inheritance.equalsHashCode.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("BMW", 545, 4.0);
        Engine engine1 = new Engine("BMW", 545, 4.0);
        Engine engine2 = new Engine("Audi", 500, 3.0);
        Engine engine3 = new Engine("BMW", 545, 4.0);
        GearBox gearBox = new GearBox("Automatic", 7, "BMW_Shifter" );
        GearBox gearBox1 = new GearBox("Automatic", 7, "BMW_Shifter" );
        GearBox gearBox2 = new GearBox("Automatic", 7, "Audi_Shifter");
        GearBox gearBox3 = new GearBox("Automatic", 7, "BMW_Shifter");
        Car car = new Car(123897597123L, "BMW", "M3", 120_000, engine, gearBox);
        Car car1 = new Car(123897597123L, "BMW", "M3", 120_000, engine1, gearBox1);
        Car car2 = new Car(1234543987345L, "Audi", "RS6", 130_000, engine2, gearBox2);
        Car car3 = new Car(123897597123L, "BMW", "M3", 120_000, engine3, gearBox3);
        ArrayList<Car> cars = new ArrayList<>();
        Collections.addAll(cars, car, car2);
        boolean answer = cars.contains(car1);
        System.out.println(answer);
        int pos = cars.indexOf(car1);
        System.out.println(pos);
        boolean delAnswer = cars.remove(car1);
        System.out.println(delAnswer);
        Date date = new Date();
        Date date1 = new Date();
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(date);
        boolean ans = dates.contains(date1);
        int index = dates.indexOf(date1);
        System.out.println(ans + " " + index);
        boolean an = car1.equals(car);
        System.out.println(an + " cars");
        boolean a = date.equals(date1);
        System.out.println(a);
        HashMap<Car, String> carOwner = new HashMap<>();
        carOwner.put(car, "Vasya");
        carOwner.put(car1, "Sasha");
        carOwner.put(car2, "Tolya");
        int size = carOwner.size();
        System.out.println(size);
        int carHashCode = car.hashCode();
        int carHashCode1 = car1.hashCode();
        System.out.println(carHashCode + " " + carHashCode1);
        int dateHashCode = date.hashCode();
        int dateHashCode1 = date1.hashCode();
        System.out.println(dateHashCode + " " + dateHashCode1);
        boolean answer1 = carOwner.containsKey(car3);
        System.out.println(answer1);
        String name  = carOwner.remove(car3);
        int carHashCode3 = car3.hashCode();
        System.out.println(carHashCode1 + " " + carHashCode3);
        System.out.println(name);
    }
}
