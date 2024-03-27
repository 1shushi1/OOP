package patterns.strategy.payStrategy;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class PayPalStrategy implements PayStrategy {
    private PayPalController payPalController = new PayPalController();
    private String email;
    private String password;
    private boolean signedIn;
    private Scanner s = new Scanner(System.in);

    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter your pay pal email : ");
        this.email = s.nextLine();
        System.out.println("Enter your pay pal password : ");
        this.password = s.nextLine();
        if (payPalController.verifyAvailability(email, password)) {
            signedIn = true;
            System.out.println("You've successfully entered your account.");
//            menu();
        } else {
            System.out.println("Your data incorrect. Try again.");
        }
    }

    @Override
    public boolean pay(int sumOfMoney) {
        if (signedIn) {
            if (payPalController.withdrawMoney(email, password, sumOfMoney)) {
                System.out.println("Successfully!");
                return true;
            } else {
                System.out.println("Not enough money to provide operation");
                return false;
            }
        }
        return false;
    }

//    public void menu() {
//        while (true) {
//            System.out.println("==========PayPal Menu==========");
//            System.out.println("1. Pay");
//            System.out.println("Enter a number : ");
//            int sel = Integer.parseInt(s.nextLine());
//            switch (sel) {
//                case 1:
//                    System.out.println("Enter an amount of money you would like to pay : ");
//                    pay(Integer.parseInt(s.nextLine()));
//                    break;
//            }
//        }
//    }
}
