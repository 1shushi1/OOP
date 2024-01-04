package multithreading.synchonized.carFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.util.Iterator;

public class Ship {
    private ArrayList<Car> cars = new ArrayList<>();
    private int shipSize;
    private BufferedWriter writer;

    public Ship(int shipSize, BufferedWriter writer) {
        this.shipSize = shipSize;
        this.writer = writer;
    }

    public synchronized void parkCarsToShip(Car loadedCar) throws SerialNumberException {
        if (cars.size() < shipSize) {
            for (Car car : cars) {
                if (car.getSerialNumber() == loadedCar.getSerialNumber()) {
                    throw new SerialNumberException(car.getSerialNumber() + " is already on the ship");
                }
            }
            try {
                cars.add(loadedCar);
                writer.append(loadedCar + " was put to the ship\n");
                System.out.println(loadedCar + " was put to the ship");
            } catch (IOException e) {
            }
        }
    }

    public synchronized void clear() {
        try {
            cars.clear();
            System.out.println("Ship was towed by the tow boat");
            writer.append("Ship was towed by the tow boat\n");
        } catch (IOException e) {
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public int getShipSize() {
        return shipSize;
    }
}
