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


        } catch (IOException e){
        }
    }
}
