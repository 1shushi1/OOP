package io.text.toyTextZipIO;

import io.text.toyTextIO.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ToyController {
    public static boolean saveAll(ArrayList<Toy> toys) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File("toys.zip"))))) {
            ZipEntry zipEntry = new ZipEntry("toys.txt");
            zipOutputStream.putNextEntry(zipEntry);
            PrintStream printStream = new PrintStream(zipOutputStream);
            for (Toy toy : toys) {
                printStream.println(toy);
            }
            zipOutputStream.closeEntry();
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public static ArrayList<Toy> findAll() {
        ArrayList<Toy> toys = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File("toys.zip"))))) {
            zipInputStream.getNextEntry();
            BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
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
            zipInputStream.closeEntry();
        } catch (IOException e) {
        }
        return toys;
    }

    public static boolean save(Toy toy) {
        try (ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File("toys.zip"), true)))) {
            ZipEntry zipEntry = new ZipEntry("toys.txt");
            outputStream.putNextEntry(zipEntry);
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(toy);
            outputStream.closeEntry();
            return true;
        } catch (IOException e) {
        }
        return false;
    }

    public static boolean delete(Toy toy) {
        ArrayList<Toy> foundToys = findAll();
        return foundToys.remove(toy) && saveAll(foundToys);
    }

    public static boolean update(Toy oldToy, Toy newToy) {
        return delete(oldToy) && save(newToy);
    }

    public static ArrayList<Toy> find(int age) {
        ArrayList<Toy> toys = findAll();
        ArrayList<Toy> foundToys  = new ArrayList<>();
        for (Toy toy : toys){
            if (toy.getAgeFrom() >= age){
                foundToys.add(toy);
            }
        }
        return foundToys;
    }
    public static ArrayList<Toy> find(ArrayList<String> fitchers){
        ArrayList<Toy> toys = findAll();
        ArrayList<Toy> foundToys  = new ArrayList<>();
        for (Toy toy : toys){
            HashMap<String, Integer> fitcher = toy.getFitcherMap();
            for (String detail : fitcher.keySet()){
                if (fitchers.contains(detail)){
                    foundToys.add(toy);
                    break;
                }
            }
        }
        return foundToys;
    }

}
