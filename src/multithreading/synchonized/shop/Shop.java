package multithreading.synchonized.shop;

import io.text.toyTextIO.Toy;

import java.io.*;
import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products;
    private int maxSize;
    private BufferedWriter writer;

    public Shop(int maxSize, BufferedWriter writer) {
        this.maxSize = maxSize;
        products = new ArrayList<>();
        this.writer = writer;
    }

    public synchronized void saveProduct(Product product) {
        if (products.size() < maxSize) {
            try {
                products.add(product);
                writer.append("Shop received product : " + product + "\n");
                System.out.println("Shop received product : " + product);
            } catch (IOException e) {
            }
        } else {
            try {
                writer.append("Not enough space at shop" + "\n");
                System.out.println("Not enough space at shop");
            } catch (IOException e){
            }
        }
    }

    public synchronized Product sellProduct(String brand, String type, String name) {
        Product foundProduct = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getBrand().equals(brand) && products.get(i).getType().equals(type)) {
                try {
                    foundProduct = products.remove(i);
                    writer.append(name + " bought product " + foundProduct + "\n");
                    System.out.println(name + " bought product : " + foundProduct);
                    return foundProduct;
                } catch (IOException e) {
                }
            }
        }
        try {
            writer.append("SHOP was requested with  : " + brand + " - " + type + " by " + name+ ". But product was not found ");
            System.out.println("SHOP was requested with  : " + brand + " - " + type + " by " + name + ". But product was not found ");
        } catch (IOException e) {
        }
        return foundProduct;
    }
}
