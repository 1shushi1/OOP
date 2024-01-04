package io.bytes.objectIO;

import java.io.*;
import java.util.ArrayList;

public class PhoneController {
    public static boolean saveAll(ArrayList<Phone> phones){
        File file = new File("phones.obj");
        boolean ans = file.delete();
        if (ans) {
            try (MyObjectOutputStream output = new MyObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
                for (Phone phone : phones){
                    output.writeObject(phone);
                }
                return true;
            } catch (IOException e) {

            }
        }
        return false;
    }
    public static boolean save(Phone phone) {
        try(MyObjectOutputStream output = new MyObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("phones.obj"), true)))){
            output.writeObject(phone);
            return true;
        } catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean delete(Phone phone){
        ArrayList foundPhones = findAll();
        boolean ans = foundPhones.remove(phone);

        if (ans){
            return saveAll(foundPhones);
        }
        return false;
    }
    public static ArrayList<Phone> findAll(){
        ArrayList<Phone> phones = new ArrayList<>();
        try (MyObjectInputStream input = new MyObjectInputStream(new BufferedInputStream(new FileInputStream(new File("phones.obj"))))){
            try {
                while(true){
                    Object object = input.readObject();
                    Phone phone = (Phone) object;
                    phones.add(phone);
                }
            } catch (ClassNotFoundException b){
            } catch (EOFException e){
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return phones;
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
    private static class MyObjectOutputStream extends ObjectOutputStream{
        public MyObjectOutputStream(OutputStream output) throws IOException{
            super(output);
        }
        @Override
        public void writeStreamHeader(){
        }
    }
    private static class MyObjectInputStream extends ObjectInputStream{
        public MyObjectInputStream(InputStream input) throws IOException{
            super(input);
        }
        @Override
        public void readStreamHeader(){
        }
    }
}
