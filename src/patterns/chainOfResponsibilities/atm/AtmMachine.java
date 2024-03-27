package patterns.chainOfResponsibilities.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AtmMachine {
    private CurrencyDispencer dispencer;
    private Map<Integer, Integer> currencies = new HashMap<>();
    private Scanner s = new Scanner(System.in);

    public AtmMachine() {
        currencies.put(1, 10);
        currencies.put(2, 10);
        currencies.put(5, 15);
        currencies.put(10, 5);
        currencies.put(20, 13);
        currencies.put(50, 6);
        currencies.put(100, 3);

        dispencer = new DispenceToHundred();
        CurrencyDispencer currencyDispencerToFifty = new DispenceToFifty();
        CurrencyDispencer currencyDispencerToTwenty = new DispenceToTwenty();
        CurrencyDispencer currencyDispencerToTen = new DipanceToTen();
        CurrencyDispencer currencyDispencerToFive = new DispenceToFive();
        CurrencyDispencer currencyDispencerToTwo = new DispenceToTwo();
        CurrencyDispencer currencyDispencerToOne = new DispenceToOne();
        dispencer.setNext(currencyDispencerToFifty);
        currencyDispencerToFifty.setNext(currencyDispencerToTwenty);
        currencyDispencerToTwenty.setNext(currencyDispencerToTen);
        currencyDispencerToTen.setNext(currencyDispencerToFive);
        currencyDispencerToFive.setNext(currencyDispencerToTwo);
        currencyDispencerToTwo.setNext(currencyDispencerToOne);
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
            if (amount >= 100) {
                int amountOfHundreds = amount / 100;
                int availableHundreds = currencies.get(100);
                if (availableHundreds >= amountOfHundreds) {
                    currencies.put(100, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 100 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 100;
                    if (amount > 0) {
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(100, 0);
                    System.out.println("Amount of 100 : " + availableHundreds);
                    amount -= availableHundreds * 100;
                    this.next.dispancer(new Currency(amount));
                }
            } else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DispenceToFifty extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 50) {
                int amountOfHundreds = amount / 50;
                int availableHundreds = currencies.get(50);
                if (availableHundreds >= amountOfHundreds) {
                    currencies.put(50, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 50 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 50;
                    if (amount > 0) {
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(50, 0);
                    System.out.println("Amount of 50 : " + availableHundreds);
                    amount -= availableHundreds * 50;
                    this.next.dispancer(new Currency(amount));
                }
            } else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DispenceToTwenty extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 20) {
                int amountOfHundreds = amount / 20;
                int availableHundreds = currencies.get(20);
                if (availableHundreds >= amountOfHundreds) {
                    currencies.put(20, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 20 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 20;
                    if (amount > 0) {
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(20, 0);
                    System.out.println("Amount of 20 : " + availableHundreds);
                    amount -= availableHundreds * 20;
                    this.next.dispancer(new Currency(amount));
                }
            } else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DipanceToTen extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 10){
                int amountOfHundreds = amount / 10;
                int availableHundreds = currencies.get(10);
                if (availableHundreds >= amountOfHundreds){
                    currencies.put(10, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 10 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 10;
                    if (amount > 0){
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(10, 0);
                    System.out.println("Amount of 10 : " + availableHundreds);
                    amount -= availableHundreds * 10;
                    this.next.dispancer(new Currency(amount));
                }
            }
            else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DispenceToFive extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 5){
                int amountOfHundreds = amount / 5;
                int availableHundreds = currencies.get(5);
                if (availableHundreds >= amountOfHundreds){
                    currencies.put(5, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 5 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 5;
                    if (amount > 0){
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(5, 0);
                    System.out.println("Amount of 5 : " + availableHundreds);
                    amount -= availableHundreds * 5;
                    this.next.dispancer(new Currency(amount));
                }
            }
            else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DispenceToTwo extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 2){
                int amountOfHundreds = amount / 2;
                int availableHundreds = currencies.get(2);
                if (availableHundreds >= amountOfHundreds){
                    currencies.put(2, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 2 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 2;
                    if (amount > 0){
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(2, 0);
                    System.out.println("Amount of 2 : " + availableHundreds);
                    amount -= availableHundreds * 2;
                    this.next.dispancer(new Currency(amount));
                }
            }
            else {
                this.next.dispancer(currency);
            }
        }
    }

    private class DispenceToOne extends CurrencyDispencer {
        @Override
        public void dispancer(Currency currency) {
            int amount = currency.getAmount();
            if (amount >= 1){
                int amountOfHundreds = amount / 1;
                int availableHundreds = currencies.get(1);
                if (availableHundreds >= amountOfHundreds){
                    currencies.put(100, availableHundreds - amountOfHundreds);
                    System.out.println("Amount of 1 : " + amountOfHundreds);
                    amount -= amountOfHundreds * 1;
                    if (amount > 0){
                        this.next.dispancer(new Currency(amount));
                    }
                } else {
                    currencies.put(1, 0);
                    System.out.println("Amount of 1 : " + availableHundreds);
                    amount -= availableHundreds * 1;
                    this.next.dispancer(new Currency(amount));
                }
            }
            else {
                this.next.dispancer(currency);
            }
        }
    }
}
