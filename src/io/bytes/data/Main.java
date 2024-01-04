package io.bytes.data;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> productList = new ArrayList<>();

        Product watch = new Product("Apple Watch", "Apple", new Date(2023-1900, 11, 23),
                765.99, true, ProductController.getPhoto("8395864.jpg"));
        Product phone = new Product("IPhone 15 Pro Max", "Apple", new Date(2023-1900, 8, 15),
                1599.99, true, ProductController.getPhoto("IMG_4308.jpg"));
        Product playStation = new Product("PlayStation 5", "Sony", new Date(2019-1900, 4,14),
                514.99, true, ProductController.getPhoto("IMG_4307_auto_x2.jpg"));

        //saveProduct checker
//        ProductController.saveProduct(watch);
//        ProductController.saveProduct(phone);
//        ProductController.saveProduct(playStation);

        //findAll checker
//        productList = ProductController.findAll();
//        for(Product product : productList){
//            System.out.println(product);
//        }
        ProductWindow productWindow = new ProductWindow();
        productWindow.menu();
    }
}
