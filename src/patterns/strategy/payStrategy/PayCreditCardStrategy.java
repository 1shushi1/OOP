package patterns.strategy.payStrategy;

import java.util.Date;
import java.util.Scanner;

public class PayCreditCardStrategy implements PayStrategy {
    private CreditCard creditCard = null;
    private CreditCardController creditCardController = new CreditCardController();
    private Scanner s = new Scanner(System.in);
    private boolean correctVerification;

    @Override
    public void collectPaymentDetails() {
        System.out.println("Enter your card number : ");
        String cardNumber = s.nextLine();
        System.out.println("Enter CVV number : ");
        String cvv = s.nextLine();
        System.out.println("Enter expiration month : ");
        int month = s.nextInt();
        System.out.println("Enter expiration year : ");
        int year = s.nextInt() - 1900;
        Date date = new Date(year, month, 1);
        if (creditCardController.verifyAvailability(cardNumber, cvv, date)) {
            this.creditCard = new CreditCard(cardNumber, cvv, date);
            correctVerification = true;
            System.out.println("Correct verification!");
//            menu();
        } else {
            System.out.println("Details you've entered is incorrect. Try again.");
        }

    }

    @Override
    public boolean pay(int sumOfMoney) {
        if (correctVerification) {
            if (creditCardController.withdrawMoney(creditCard.getCardNumber(), creditCard.getCvv(), sumOfMoney, creditCard.getExpiryDate())) {
                System.out.println("You've successfully withdraw money");
                return true;
            }
        }
        System.out.println("Operation failed");
        return false;
    }

//    public void menu() {
//        while (true) {
//            System.out.println("==========CreditCard Menu==========");
//            System.out.println("1. Pay");
//            System.out.println("Enter a number : ");
//            int sel = s.nextInt();
//            s.nextLine();
//            switch (sel) {
//                case 1:
//                    System.out.println("Enter an amount of money you would like to pay : ");
//                    pay(s.nextInt());
//                    break;
//                case 2:
//            }
//        }
//    }
}
