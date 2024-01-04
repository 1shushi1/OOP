package io.bytes.objectIO;

import java.io.*;
import java.util.ArrayList;

public class PhoneControllerList {
    public static boolean saveAll(ArrayList<Phone> phones){
            try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("phonesList.obj")))) {
                output.writeObject(phones);
                return true;
            } catch (IOException e) {
            }
        return false;
    }
    public static boolean save(Phone phone) {
            ArrayList foundPhones = findAll();
            foundPhones.add(phone);
            return saveAll(foundPhones);
    }
    public static boolean delete(Phone phone){
        ArrayList foundPhones = findAll();
        return (foundPhones.remove(phone)) ? saveAll(foundPhones) : false;
    }
    public static ArrayList<Phone> findAll(){
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("phonesList.obj"))))){
            return (ArrayList<Phone>) input.readObject();
        } catch (IOException e){
        } catch (ClassNotFoundException e){
        }
        return new ArrayList<>();
    }
    //finish update
    public static boolean update(Phone oldPhone, Phone newPhone){
        return delete(oldPhone) && save(newPhone);
    }
    public static ArrayList<Phone> find(String brand, String model){
        ArrayList<Phone> foundPhone = new ArrayList<>();
        ArrayList<Phone> phones = findAll();
        for (Phone phone : phones){
            if (phone.getBrand().equals(brand) && phone.getModel().equals(model)){
                foundPhone.add(phone);
            }
        }
        return foundPhone;
    }
    public static ArrayList<Phone> find(double priceFrom, double priceTo){
        ArrayList<Phone> foundPhone = new ArrayList<>();
        ArrayList<Phone> phones = findAll();
        for (Phone phone : phones){
            if (phone.getPrice() >= priceFrom && phone.getPrice() <= priceFrom){
                foundPhone.add(phone);
            }
        }
        return foundPhone;
    }
    public static byte [] getPhoto(String path){
        byte[] photo = null;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(path)));
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            int a = 0;
            while ((a = input.read()) != -1) {
                output.write(a);
            }
            photo = output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photo;
    }
}

