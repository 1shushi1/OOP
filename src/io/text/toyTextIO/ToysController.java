package io.text.toyTextIO;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ToysController {
    public static ArrayList<Toy> findAll() {
        ArrayList<Toy> toys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("toys.txt")))) {
            String empty = "";
            Toy toy;
            while ((empty = reader.readLine()) != null) {
                String[] arr = empty.split(":");
                String title = arr[1].substring(1);
                empty = reader.readLine();
                arr = empty.split(":");
                double price = Double.parseDouble(arr[1].substring(1));
                empty = reader.readLine();
                arr = empty.split(":");
                String brand = arr[1].substring(1);
                empty = reader.readLine();
                HashMap<String, Integer> map = new HashMap<>();
                while (!(empty = reader.readLine()).startsWith("Age")) {
                    arr = empty.split("-");
                    map.put(arr[0].substring(0, arr[0].length() - 1), Integer.parseInt(arr[1].substring(1)));
                }
                arr = empty.split(":");
                int ageFrom = Integer.parseInt(arr[1].substring(1));
                empty = reader.readLine();
                arr = empty.split(":");
                String material = arr[1].substring(1);
                toy = new Toy(title, price, brand, map, ageFrom, material);
                toys.add(toy);
            }
        } catch (IOException e) {
        }
        return toys;
    }

    public static boolean saveAll(ArrayList<Toy> toys) {
        File file = new File("toys.txt");
        file.delete();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("toys.txt"), true))) {
            for (Toy toy : toys) {
                writer.append(toy + "\n");
            }
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public static boolean save(Toy toy) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("toys.txt"), true))) {
            writer.append(toy + "\n");
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public static boolean delete(Toy toy) {
        ArrayList<Toy> foundToys = findAll();
        if (foundToys.remove(toy)) {
            return saveAll(foundToys);
        }
        return false;
    }

    public static boolean update(Toy oldToy, Toy newToy) {
        return delete(oldToy) && save(newToy);
    }

    public static ArrayList<Toy> find(int ageFrom, int ageTo) {
        ArrayList<Toy> foundToys = new ArrayList<>();
        ArrayList<Toy> toys = findAll();
        for(Toy toy : toys){
            if (toy.getAgeFrom() >= ageFrom && toy.getAgeFrom() <= ageTo){
                foundToys.add(toy);
            }
        }
        return foundToys;
    }
}
