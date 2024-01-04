package nio.objects;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CarController {
    public static boolean save(Car car) {
        ArrayList<Car> cars = findAll();
        cars.add(car);
        return saveAll(cars);
    }

    public static ArrayList<Car> findAll() {
        Path path = Path.of("Files/Photos/Cars.obj");
        OpenOption[] options = {StandardOpenOption.READ};
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path, options))) {
            return (ArrayList<Car>) input.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return new ArrayList<>();
    }

    public static boolean saveAll(ArrayList<Car> cars) {
        Path path = Path.of("Files/Photos/Cars.obj");
        try {
            Files.delete(path);
        } catch (IOException e) {
        }
        OpenOption[] options = {StandardOpenOption.WRITE, StandardOpenOption.CREATE};
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path, options))) {
            output.writeObject(cars);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean update(Car oldCar, Car newCar){
        return delete(oldCar) && save(newCar);
    }
    public static boolean delete(Car car){
        ArrayList<Car> cars = findAll();
        boolean ans = cars.remove(car);
        if (ans){
            return saveAll(cars);
        }
        return false;
    }
}
