package multithreading.synchonized.waifNotify.shop;

import java.io.BufferedWriter;
import java.io.IOException;
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
        try {
            if (products.size() == maxSize) {
                wait();
            }
            products.add(product);
            writer.append(product + " \nWas saved to the shop\n");
            System.out.println(product + " \nWas saved to the shop");
            notifyAll();
        } catch (IOException | InterruptedException e){
        }
    }

    public synchronized Product sellProduct(String brand, String type, String name) {
          Product foundProduct = null;
        try {
            if (products.size() == 0){
                wait();
            }
            for (int i = 0; i < products.size(); i++){
                if (products.get(i).getBrand().equals(brand) && products.get(i).getType().equals(type)){
                    foundProduct = products.remove(i);
                    writer.append(name + " bought product " + foundProduct + "\n");
                    System.out.println(name + " bought product : " + foundProduct);
                }
            }
            notifyAll();
        } catch (IOException | InterruptedException e){
        }
        return foundProduct;
    }
}
