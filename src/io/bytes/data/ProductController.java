package io.bytes.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductController {

    public static boolean saveAll(ArrayList<Product> arrList){
        File file = new File("products.dat");
        boolean ans = file.delete();
        if (ans){
            try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
                for (Product product : arrList){
                    output.writeUTF(product.getTitle());
                    output.writeUTF(product.getBrand());
                    output.writeLong(product.getDate().getTime());
                    output.writeDouble(product.getPrice());
                    if (product.getPhoto() != null) {
                        output.writeInt(product.getPhoto().length);
                        for (byte b : product.getPhoto()) {
                            output.writeByte(b);
                        }
                    } else {
                        output.writeInt(0);
                    }
                }
                return true;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean saveProduct(Product product) {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("products.dat"), true)))) {
            output.writeUTF(product.getTitle());
            output.writeUTF(product.getBrand());
            output.writeLong(product.getDate().getTime());
            output.writeDouble(product.getPrice());
            output.writeBoolean(product.isAvailable());
            if (product.getPhoto() != null) {
                output.writeInt(product.getPhoto().length);
                for (byte b : product.getPhoto()) {
                    output.writeByte(b);
                }
            } else {
                output.writeInt(0);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteProduct(Product product) {
        ArrayList<Product> productsList = findAll();

        boolean ans = productsList.remove(product);

        if (ans) {
            return saveAll(productsList);
        }
        return false;
    }

    public static boolean update(Product oldProduct, Product newProduct) {
//        boolean ans = deleteProduct(oldProduct);
//        if (ans){
//            return saveProduct(newProduct);
//        }
//        return false;

//        return deleteProduct(oldProduct) ? saveProduct(newProduct) : false;

        return deleteProduct(oldProduct) && saveProduct(newProduct);
    }

    public static ArrayList<Product> find(String brand, String title) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        ArrayList<Product> products = findAll();
        for(Product product : products){
            if (product.getBrand().equals(brand) && product.getTitle().equals(title)){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
    public static ArrayList<Product> find(Double priceFrom, Double priceTo){
        ArrayList<Product> foundProducts = new ArrayList<>();
        ArrayList<Product> products = findAll();
        for (Product product : products){
            if (product.getPrice() >= priceFrom && product.getPrice() <= priceTo){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public static ArrayList<Product> findAll() {
        ArrayList<Product> productList = new ArrayList<>();
        try (DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("products.dat"))))) {
            try {
                while (true) {
                    String title = input.readUTF();
                    String brand = input.readUTF();
                    Date date = new Date(input.readLong());
                    Double price = input.readDouble();
                    boolean availability = input.readBoolean();
                    int b = input.readInt();
                    byte[] photo = null;
                    if (b != 0) {
                        photo = new byte[b];
                        for (int i = 0; i < photo.length; i++) {
                            photo[i] = input.readByte();
                        }
                    }
                    Product product = new Product(title, brand, date, price, availability, photo);
                    productList.add(product);
                }
            } catch (EOFException b){
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static byte[] getPhoto(String filePath) {
        byte[] photo = null;
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(filePath)));
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
