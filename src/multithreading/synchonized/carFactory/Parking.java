package multithreading.synchonized.carFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parking {
    private ArrayList<Car> carsParking = new ArrayList<>();
    private int parkingSize;
    private BufferedWriter writer;

    public Parking(BufferedWriter writer, int parkingSize) {
        this.parkingSize = parkingSize;
        this.writer = writer;
    }

    public synchronized void parkCar(Car car) {
        if (carsParking.size() < parkingSize) {
            try {
                carsParking.add(car);
                writer.append("Car : " + car + " was produced and put to parking \n");
                System.out.println("Car : " + car + " was produced and put to parking");
            } catch (IOException e) {
            }
        } else {
            try {
                writer.append("Not enough space to park a car : " + car + "\n");
                System.out.println("Not enough space to park a car : " + car);
            } catch (IOException e) {
            }
        }
    }

    public synchronized ArrayList<Car> giveCar(int amount) {
        Car car;
        ArrayList<Car> carsToGive = new ArrayList<>();
        if (amount >= carsParking.size()) {
            try {
                carsToGive.addAll(carsParking);
                for (Car car1 : carsToGive) {
                    writer.append("Truck loaded a car with brand : " + car1.getBrand() + " and serial number : " + car1.getSerialNumber() + "\n");
                    System.out.println("Truck loaded a car with brand : " + car1.getBrand() + " and serial number : " + car1.getSerialNumber());
                }
                carsParking.clear();
            } catch (IOException e) {
            }
        } else if (amount < carsParking.size()) {
            for (int i = 0; i < amount;i++) {
                try {
                    car = carsParking.remove(0);
                    carsToGive.add(car);
                    writer.append("Truck loaded a car with brand : " + car.getBrand() + " and serial number : " + car.getSerialNumber() +
                                    "\nRequested amount was smaller\n");
                    System.out.println("Truck loaded a car with brand : " + car.getBrand() + " and serial number : " + car.getSerialNumber() +
                                    "\nRequested amount was smaller");
                } catch (IOException e) {
                }
            }
        }
        return carsToGive;
    }
}
