package multithreading.synchonized.shop;

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
//        double priceForPhone = 0;
//        double priceForLaptop = 0;
//        double priceForEarphones = 0;
//        if (brand.equalsIgnoreCase("Apple")){
//            String [] type = {"Phone", "Laptop", "Earphones"};
//            int num = r.nextInt(3);
//            if (type[num].equalsIgnoreCase("Phone")){
//                priceForPhone = r.nextDouble(1500-1100) + 1100;
//                shop.saveProduct(new Product(brand, type[num], priceForPhone));
//            } else if (type[num].equalsIgnoreCase("Laptop")){
//                priceForLaptop = r.nextDouble(2000-1350) + 1350;
//                shop.saveProduct(new Product(brand, type[num], priceForLaptop));
//            } else {
//                priceForEarphones = r.nextDouble(300-100) + 100;
//                shop.saveProduct(new Product(brand, type[num], priceForEarphones));
//            }
//        } else if (brand.equalsIgnoreCase("Samsung")){
//            String [] type = {"Phone", "Laptop", "Earphones"};
//            int num = r.nextInt(3);
//            if (type[num].equalsIgnoreCase("Phone")){
//                priceForPhone = r.nextDouble(1300-900) + 900;
//                shop.saveProduct(new Product(brand, type[num], priceForPhone));
//            } else if (type[num].equalsIgnoreCase("Laptop")){
//                priceForLaptop = r.nextDouble(1500-700) + 700;
//                shop.saveProduct(new Product(brand, type[num], priceForLaptop));
//            } else {
//                priceForEarphones = r.nextDouble(90-50) + 50;
//                shop.saveProduct(new Product(brand, type[num], priceForEarphones));
//            }
//        } else if (brand.equalsIgnoreCase("Xiaomi")){
//            String [] type = {"Phone", "Laptop", "Earphones"};
//            int num = r.nextInt(3);
//            if (type[num].equalsIgnoreCase("Phone")){
//                priceForPhone = r.nextDouble(800-400) + 400;
//                shop.saveProduct(new Product(brand, type[num], priceForPhone));
//            } else if (type[num].equalsIgnoreCase("Laptop")){
//                priceForLaptop = r.nextDouble(900-450) + 450;
//                shop.saveProduct(new Product(brand, type[num], priceForLaptop));
//            } else {
//                priceForEarphones = r.nextDouble(35-25) + 25;
//                shop.saveProduct(new Product(brand, type[num], priceForEarphones));
//            }
//        }
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
