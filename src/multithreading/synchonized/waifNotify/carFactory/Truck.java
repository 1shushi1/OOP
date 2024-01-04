package multithreading.synchonized.waifNotify.carFactory;


import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Truck extends Thread {
    private ArrayList<Car> cars = new ArrayList<>();
    private int truckSize;
    private BufferedWriter writer;
    private ArrayList<Parking> parkings;
    private Ship ship;
    private Trash trash;

    public Truck(BufferedWriter writer, int truckSize, ArrayList<Parking> parkings, Ship ship, Trash trash) {
        this.truckSize = truckSize;
        this.writer = writer;
        this.parkings = parkings;
        this.ship = ship;
        this.trash = trash;
    }

    @Override
    public void run() {
        while (true) {
            try {
                label: while (cars.size() < truckSize) {
                    for (Parking parking : parkings) {
                        int amountLeft = truckSize - cars.size();
                        cars.addAll(parking.giveCar(amountLeft));
                        sleep(1000);
                        if (cars.size() == truckSize) {
                            break;
                        }
                    }
                }
                sleep(2000);
                System.out.println("Truck was loaded and now is going to the ship");
                writer.append("Truck was loaded and now is going to the ship\n");
                Car car = null;
                for (;cars.size() > 0;){
                    try {
                        if (ship.getCarsSize() < ship.getShipSize()){
                            car = cars.remove(0);
                            ship.parkCarsToShip(car);
                        }
                    } catch (SerialNumberException e){
                        trash.putCarToTheTrash(car);
                    }
                }
                writer.append("Truck is coming back from the ship\n");
                System.out.println("Truck is coming back from the ship");
                sleep(2000);
            } catch (InterruptedException | IOException e){
            }
        }
    }
}
