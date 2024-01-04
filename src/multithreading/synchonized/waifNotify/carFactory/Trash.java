package multithreading.synchonized.waifNotify.carFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Trash {
    private ArrayList<Car> cars = new ArrayList<>();
    private BufferedWriter writer;
    public Trash(BufferedWriter writer){
        this.writer = writer;
    }
    public void putCarToTheTrash(Car car){
        try {
            cars.add(car);
            writer.append("Car : " + car + " was put to the trash parking\n");
            System.out.println("Car : " + car + " was put to the trash parking");
        } catch(IOException e){
        }
    }
}
