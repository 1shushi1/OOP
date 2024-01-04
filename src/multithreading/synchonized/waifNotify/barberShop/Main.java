package multithreading.synchonized.waifNotify.barberShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("barberShop.txt")))){

            BarberShop barberShop = new BarberShop(2, 5, writer);

            ClientGenerator clientGenerator1 = new ClientGenerator(barberShop, 1, 4, 1, 3);
            ClientGenerator clientGenerator2 = new ClientGenerator(barberShop, 1, 3, 1, 3);
            ClientGenerator clientGenerator3 = new ClientGenerator(barberShop, 1, 2, 1, 3);

            BarberShop.Barber barber1 = barberShop.new Barber(1);
            BarberShop.Barber barber2 = barberShop.new Barber(2);

            BarberShop.QueueMonitoring queueMonitoring = barberShop.new QueueMonitoring();

            barber1.setDaemon(true);
            barber2.setDaemon(true);

            clientGenerator1.setDaemon(true);
            clientGenerator2.setDaemon(true);
            clientGenerator3.setDaemon(true);

            queueMonitoring.setDaemon(true);

            barber1.start();
            barber2.start();

            clientGenerator1.start();
            clientGenerator2.start();
            clientGenerator3.start();

            queueMonitoring.start();

            Thread.sleep(40000);
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
