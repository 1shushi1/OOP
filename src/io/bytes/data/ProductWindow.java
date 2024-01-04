package io.bytes.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductWindow {
    private static Scanner s = new Scanner(System.in);
    public static void menu(){
        while(true){
            System.out.println("Select 1 - Save, 2 - Delete, 3 - Update, 4 - Find by Price, 5 - Find by Brand and Title");
            int sel = Integer.parseInt(s.nextLine());
            switch (sel){
                case 1 : boolean ans1 = save();
                    System.out.println(ans1);
                    break;
                case 2 : boolean ans2 = delete();
                    System.out.println(ans2);
                    break;
                case 3 : boolean ans3 = update();
                    System.out.println(ans3);
                    break;
                case 4 : ArrayList<Product> foundProductByPrice = findByPrice();
                    System.out.println(foundProductByPrice);
                    break;
                case 5 : ArrayList<Product> foundProductByTitleAndBrand = findByBrandName();
                    System.out.println(foundProductByTitleAndBrand);
                    break;
            }
        }
    }
    private static boolean save(){
        System.out.println("Enter a product title");
        String title = s.nextLine();
        System.out.println("Enter a product brand");
        String brand = s.nextLine();
        System.out.println("Enter year");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Enter month");
        int month = Integer.parseInt(s.nextLine());
        System.out.println("Enter day");
        int day = Integer.parseInt(s.nextLine());
        Date date = new Date(year-1900, month, day);
        System.out.println("Enter price");
        Double price = Double.parseDouble(s.nextLine());
        System.out.println("Enter availability");
        boolean isAvailable = Boolean.parseBoolean(s.nextLine());
        System.out.println("Provide photo file ( 1 - if you have, 2 - if not )");
        int ans = Integer.parseInt(s.nextLine());
        byte [] photo = null;
        if (ans == 1){
            System.out.println("Enter a file name");
            String photoName = s.nextLine();
        }
        Product product = new Product(title, brand, date, price, isAvailable, photo);
        return ProductController.saveProduct(product);
    }
    public static boolean delete(){
        System.out.println("Enter a product title you would like to delete");
        String title = s.nextLine();
        System.out.println("Enter a product brand you would like to delete");
        String brand = s.nextLine();
        System.out.println("Enter price");
        Double price = Double.parseDouble(s.nextLine());
        Product product = new Product(title, brand, price);
        return ProductController.deleteProduct(product);
    }
    public static boolean update(){
        System.out.println("Enter a product title you would like to delete");
        String title = s.nextLine();
        System.out.println("Enter a product brand you would like to delete");
        String brand = s.nextLine();
        System.out.println("Enter price");
        Double price = Double.parseDouble(s.nextLine());
        Product oldProduct = new Product(title, brand, price);
        System.out.println("Enter a product brand");
        String newBrand = s.nextLine();
        System.out.println("Enter a product title");
        String newTitle = s.nextLine();
        System.out.println("Enter year");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Enter month");
        int month = Integer.parseInt(s.nextLine());
        System.out.println("Enter day");
        int day = Integer.parseInt(s.nextLine());
        Date date = new Date(year-1900, month, day);
        System.out.println("Enter price");
        Double newPrice = Double.parseDouble(s.nextLine());
        System.out.println("Enter availability");
        boolean isAvailable = Boolean.parseBoolean(s.nextLine());
        System.out.println("Provide photo file ( 1 - if you have, 2 - if not )");
        int ans = Integer.parseInt(s.nextLine());
        byte [] photo = null;
        if (ans == 1){
            System.out.println("Enter a file name");
            String photoName = s.nextLine();
        }
        Product newProduct = new Product(newTitle, newBrand, date, newPrice, isAvailable, photo);
        return ProductController.update(oldProduct, newProduct);
    }
    public static ArrayList<Product> findByPrice(){
        System.out.println("Enter a price range. \nFrom which : ");
        double from = Double.parseDouble(s.nextLine());
        System.out.println("To which : ");
        double to = Double.parseDouble(s.nextLine());
        ArrayList foundProduct = ProductController.find(from, to);
        return foundProduct;
    }
    public static ArrayList<Product> findByBrandName(){
        System.out.println("Enter a product title");
        String title = s.nextLine();
        System.out.println("Enter a product brand");
        String brand = s.nextLine();
        ArrayList foundProduct = ProductController.find(brand, title);
        return foundProduct;
    }
}
