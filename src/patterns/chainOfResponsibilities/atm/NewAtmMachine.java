package patterns.chainOfResponsibilities.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewAtmMachine {
    private CurrencyDispencer dispencer;
    private Map<Integer, Integer> currencies = new HashMap<>();
    private Scanner s = new Scanner(System.in);

    public NewAtmMachine() {
        currencies.put(1, 10);
        currencies.put(2, 10);
        currencies.put(5, 15);
        currencies.put(10, 5);
        currencies.put(20, 13);
        currencies.put(50, 6);
        currencies.put(100, 3);

        dispencer = new DispenceToHundred();
//        CurrencyDispencer currencyDispencerToFifty = new AtmMachine.DispenceToFifty();
//        CurrencyDispencer currencyDispencerToTwenty = new AtmMachine.DispenceToTwenty();
//        CurrencyDispencer currencyDispencerToTen = new AtmMachine.DipanceToTen();
//        CurrencyDispencer currencyDispencerToFive = new AtmMachine.DispenceToFive();
//        CurrencyDispencer currencyDispencerToTwo = new AtmMachine.DispenceToTwo();
//        CurrencyDispencer currencyDispencerToOne = new AtmMachine.DispenceToOne();
//        dispencer.setNext(currencyDispencerToFifty);
//        currencyDispencerToFifty.setNext(currencyDispencerToTwenty);
//        currencyDispencerToTwenty.setNext(currencyDispencerToTen);
//        currencyDispencerToTen.setNext(currencyDispencerToFive);
//        currencyDispencerToFive.setNext(currencyDispencerToTwo);
//        currencyDispencerToTwo.setNext(currencyDispencerToOne);
        menu();
    }

    public void receive(Currency currency) {
        dispencer.dispancer(currency);
    }

    public void menu() {
        while (true) {
            System.out.println("Enter an amount you would like to dispence : ");
            int amount = s.nextInt();
            System.out.println("1 - Change money, 2 - Exit");
            int sel = s.nextInt();
            switch (sel) {
                case 1 -> receive(new Currency(amount));
                case 2 -> System.exit(0);
            }
        }
    }


    private class DispenceToHundred extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 100){
                int amountOfHundreds = amount / 100;
                int availableHundreds = currencies.get(100);
                if (availableHundreds >= amountOfHundreds){
                    currencies.put(100, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of hundreds : " + amountOfHundreds);
                    amount -= amountOfHundreds * 100;
                    if (amount > 0){
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(100, 0);
                    System.out.println("Amount of hundreds : " + availableHundreds);
                    amount -= availableHundreds * 100;
                    this.next.dispancer(new Currency(amount));
                }
            }
            else {
                this.next.dispancer(currency);
            }
        }
    }
}
