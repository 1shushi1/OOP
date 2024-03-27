package patterns.strategy.payStrategy;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ClientProgram {
    private Order order;
    private ProductController productController;
    private PayStrategy payStrategy;
    private Scanner s = new Scanner(System.in);
    private StorageController storageController = new StorageController();
    public ClientProgram(){
        menu();
    }
    private void menu(){
        while (true){
            System.out.println("========Menu========");
            System.out.println("1. Create an order");
            System.out.println("2. Exit");
            System.out.println("Select from the above");
            int sel = s.nextInt();
            switch (sel){
                case 1 -> createOrder();
                case 2 -> System.exit(0);
            }
        }
    }
    private void createOrder(){
        order = new Order();
        List<Product> availableProducts = ProductController.convertedListOfProducts("product_for_sale");
        int index [] = new int[1];
        availableProducts.forEach(e -> {
            System.out.println(index[0]++ + ". " + e);
        });
       lable : while(true){
            System.out.println("Select number :");
            System.out.println("1. Add product to cart :");
            System.out.println("0. Or finish your order");
            int sel = s.nextInt();
            switch (sel){
                case 0 : break lable;
                case 1 :
                    System.out.println("Select a product from list by number : ");
                    int productSel = s.nextInt();
                    System.out.println("Enter amount you would like to take : ");
                    int amount = s.nextInt();
                    Product product = availableProducts.get(productSel).clone();
                    order.addProduct(product, amount);
            }
        }

        System.out.println("Select a paying method : ");
        System.out.println("1. PayPal");
        System.out.println("2. Credit Card");
        int sel = s.nextInt();
        if (sel == 1){
            this.payStrategy = new PayPalStrategy();
        } else {
            this.payStrategy = new PayCreditCardStrategy();
        }
        int totalToPay = order.totalPriceCalculator();
        System.out.println("To pay : " + totalToPay);
        payStrategy.collectPaymentDetails();
        boolean ans = payStrategy.pay(totalToPay);
        if (ans){
            System.out.println("You've successfully paid for you order");
            order.setState(OrderState.PAID);
            storageController.putToStorage(order);
        } else {
            System.out.println("Unsuccessfully. Try again");
        }
    }
}
