package multithreading.synchonized.shop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("shop.txt")))){
            Shop shop = new Shop(15, writer);

            Supplier supplier1 = new Supplier("Apple", shop);
            Supplier supplier2 = new Supplier("Samsung", shop);
            Supplier supplier3 = new Supplier("Xiaomi", shop);

            Client client1 = new Client("Vasya", shop);
            Client client2 = new Client("Tolya", shop);
            Client client3 = new Client("Sasha", shop);

            supplier1.setDaemon(true);
            supplier2.setDaemon(true);
            supplier3.setDaemon(true);

            client1.setDaemon(true);
            client2.setDaemon(true);
            client3.setDaemon(true);

            supplier1.start();
            supplier2.start();
            supplier3.start();

            client1.start();
            client2.start();
            client3.start();

            Thread.sleep(40000);
        } catch (IOException | InterruptedException e){
        }
    }
}
