package multithreading.synchonized.waifNotify.shop;

import java.util.Random;

public class Supplier extends Thread {
    private String brand;
    private Shop shop;
    private final static double[][] prices = {{1400, 2500, 250}, {1200, 1300, 100}, {500, 800, 50}};

    public Supplier(String brand, Shop shop) {
        this.brand = brand;
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            Random r = new Random();
            String type = null;
            int num = r.nextInt(3);
            if (num == 0) {
                type = "Phone";
            } else if (num == 1) {
                type = "Laptop";
            } else {
                type = "Earphones";
            }
            double price = 0;
            if (brand.equalsIgnoreCase("Apple")) {
                price = prices[0][num];
            } else if (brand.equalsIgnoreCase("Samsung")) {
                price = prices[1][num];
            } else if (brand.equalsIgnoreCase("Xiaomi")) {
                price = prices[2][num];
            }
            shop.saveProduct(new Product(brand, type, price));
            try {
                sleep((r.nextInt(3 - 1) + 1) * 1000);
            } catch (InterruptedException e){
            }
        }
    }
}
