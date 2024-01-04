package multithreading.synchonized.carFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("carFactory.txt")))){
            Parking bmwParking = new Parking(writer, 3);
            Parking skodaParking = new Parking(writer, 4);

            ArrayList<Parking> parkings = new ArrayList<>();

            parkings.add(bmwParking);
            parkings.add(skodaParking);

            CarFactory bmw = new CarFactory("BMW", writer, bmwParking);
            CarFactory mercedes = new CarFactory("Mercedes", writer, bmwParking);
            CarFactory skoda = new CarFactory("Skoda", writer, skodaParking);


            Ship ship = new Ship(20, writer);

            Trash trash = new Trash(writer);

            Truck truck = new Truck(writer, 8, parkings, ship, trash);

            TowBoat towBoat = new TowBoat(writer, ship);

            bmw.setDaemon(true);
            mercedes.setDaemon(true);
            skoda.setDaemon(true);

            truck.setDaemon(true);

            towBoat.setDaemon(true);

            bmw.start();
            mercedes.start();
            skoda.start();

            truck.start();

            towBoat.start();

            Thread.sleep(35000);
        } catch (IOException | InterruptedException e) {
        }
    }
}
