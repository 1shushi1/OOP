package multithreading.synchonized.waifNotify.carFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ship {
    private ArrayList<Car> cars = new ArrayList<>();
    private int shipSize;
    private BufferedWriter writer;

    public Ship(int shipSize, BufferedWriter writer) {
        this.shipSize = shipSize;
        this.writer = writer;
    }

    public synchronized void parkCarsToShip(Car loadedCar) throws SerialNumberException {
        try {
            if (cars.size() == shipSize) {
                wait();
            }
            for (Car car : cars) {
                if (car.getSerialNumber() == loadedCar.getSerialNumber()) {
                    throw new SerialNumberException(car.getSerialNumber() + " is already on the ship");
                }
            }
                cars.add(loadedCar);
                writer.append(loadedCar + " was put to the ship\n");
                System.out.println(loadedCar + " was put to the ship");
                notifyAll();
        } catch (IOException | InterruptedException e){
        }
    }

    public synchronized void clear() {
        try {
        if (cars.size() != shipSize){
            wait();
        }
            cars.clear();
            System.out.println("Ship was towed by the tow boat");
            writer.append("Ship was towed by the tow boat\n");
        } catch (IOException | InterruptedException e){
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public int getShipSize() {
        return shipSize;
    }
}
