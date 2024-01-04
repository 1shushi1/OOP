package multithreading.synchonized.waifNotify.barberShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("barberShop.txt")))){

            BarberShop barberShop = new BarberShop()

            ClientGenerator clientGenerator1 = new ClientGenerator()
        } catch (IOException e){
        }
    }
}
