package multithreading.synchonized.waifNotify.carFactory;

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
        try {
            if (carsParking.size() == parkingSize) {
                wait();
            }
            carsParking.add(car);
            writer.append("Car : " + car + " was produced and put to parking \n");
            System.out.println("Car : " + car + " was produced and put to parking");
            notifyAll();
        } catch (InterruptedException | IOException e) {
        }
    }

    public synchronized ArrayList<Car> giveCar(int amount) {
        Car car;
        ArrayList<Car> carsToGive = new ArrayList<>();
        try {
            if (carsParking.size() == 0) {
                wait();
            }
            if (amount >= carsParking.size()) {
                carsToGive.addAll(carsParking);
                for (Car car1 : carsToGive) {
                    writer.append("Truck loaded a car with brand : " + car1.getBrand() + " and serial number : " + car1.getSerialNumber() + "\n");
                    System.out.println("Truck loaded a car with brand : " + car1.getBrand() + " and serial number : " + car1.getSerialNumber());
                    carsParking.clear();
                }
            } else if (amount < carsParking.size()) {
                for (int i = 0; i < amount; i++) {
                    car = carsParking.remove(0);
                    carsToGive.add(car);
                    writer.append("Truck loaded a car with brand : " + car.getBrand() + " and serial number : " + car.getSerialNumber() +
                            "\nRequested amount was smaller\n");
                    System.out.println("Truck loaded a car with brand : " + car.getBrand() + " and serial number : " + car.getSerialNumber() +
                            "\nRequested amount was smaller");
                }
            }
            notifyAll();
        } catch (IOException | InterruptedException e) {
        }
        return carsToGive;
    }
}