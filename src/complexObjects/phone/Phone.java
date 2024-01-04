package complexObjects.phone;

import java.util.Scanner;

public class Phone {
    private Battery battery = new Battery(50);
    private Sim[] sims = new Sim[2];

    private Display display = new Display();
    private Scanner s = new Scanner(System.in);
    private boolean isOn;

    public Phone() {
        menu();
    }

    private void menu() {
            System.out.println("Enter a number : 1 - turn on/off, 2 - call, 3 - charge complexObjects.phone, 4 - top up your balance, 5 - tariff changer, 6 - insert sim,  7 - exit");
            int selection = s.nextInt();
            switch (selection) {
                case 1 -> turnOnOff();
                case 2 -> call();
                case 3 -> chargePhone();
                case 4 -> topUpPhoneBalance();
                case 5 -> tariffChanger();
                case 6 -> insertSim();
                case 7 -> System.exit(0);
            }
            menu();
    }

    private void turnOnOff() {
        if (battery.getCurrentPercentage() > 2 && isOn == false) {
            isOn = true;
            display.showDisplay("Battery percentage : " + Math.round(battery.getCurrentPercentage()));
            if (sims[0] != null) {
                display.showDisplay("Sim 1 " + sims[0].getOperator());
            } else {
                display.showDisplay("You have no sim on slot 1");
                if (sims[1] != null) {
                    display.showDisplay("Sim 2 " + sims[1].getOperator());
                } else {
                    display.showDisplay("You have no sim on slot 2");
                }
            }
        } else {
            isOn = false;
            display.showDisplay("You've turned off your complexObjects.phone");
        }
    }

    private void insertSim() {
        System.out.println("Enter a slot number");
        int slotNum = s.nextInt();
        if (slotNum > 2) {
            System.out.println("Such slot doesn't exist. Try again.");
            insertSim();
        }
        System.out.println("Enter you complexObjects.phone number");
        String phoneNumber = s.next();
        System.out.println("Enter price for tariff 1");
        double priceForTariff1 = s.nextDouble();
        System.out.println("Enter price for tariff 2");
        double priceForTariff2 = s.nextDouble();
        System.out.println("Enter price for tariff 3");
        double priceForTariff3 = s.nextDouble();
        System.out.println("Enter your start balance");
        double balance = s.nextDouble();
        System.out.println("Enter you operator name");
        String operatorName = s.next();
        sims[slotNum - 1] = new Sim(phoneNumber, priceForTariff1, priceForTariff2, priceForTariff3, balance, operatorName);
    }

    private void call() {
        if (isOn == true){
            display.showDisplay("Enter a complexObjects.phone number where you would like to call");
            String phoneNum = s.next();
            display.showDisplay("Select a sim you would like to use : 1 or 2");
            int selSim = s.nextInt();
            if (selSim <= 2 && selSim != 0){
                display.showDisplay("Enter how much time you would like to talk");
                display.showDisplay("Enter minutes");
                int minutes = s.nextInt();
                display.showDisplay("Enter seconds");
                int seconds = s.nextInt();
                seconds += minutes*60;
                double tariffPerMinute = sims[selSim  - 1].tariffYouAreUsing(phoneNum);
                for (int i = 0; i < seconds; i++){
                    sims[selSim -1].debitFundsFromBalance(tariffPerMinute);
                    battery.dischargeBattery(0.1);
                    if (sims[selSim -1].getBalance() < tariffPerMinute){
                        display.showDisplay("You have to top up balance in order to continue you call");
                        display.showDisplay("You call prolong - " + seconds/60 + " : " + seconds%60);
                        return;
                    }
                    if (battery.getCurrentPercentage() < 1){
                        display.showDisplay("You call prolong - " + seconds/60 + " : " + seconds%60);
                        isOn = false;
                        return;
                    }
                }
                display.showDisplay("You call prolong - " + seconds/60 + " : " + seconds%60);
            }
        }
    }

    private void chargePhone() {
        display.showDisplay("Enter on how much percents you would like to charge");
        double percentage = s.nextDouble();
        if (percentage > 100) {
            battery.setCurrentPercentage(100);
            display.showDisplay("You successfully charged your complexObjects.phone to " + battery.getCurrentPercentage());
        } else {
            battery.chargeBattery(percentage);
        }
    }
    private void topUpPhoneBalance(){
        if (isOn == true) {
            display.showDisplay("Select sim you would like to top up");
            display.showDisplay("Enter 1 or 2");
            int selection = s.nextInt();
            if (sims[selection - 1] == null) {
                display.showDisplay("There is no sim on slot you've selected. " +
                        "Insert sim and try again");
                return;
            }
            display.showDisplay("Enter an amount of money you would like to put");
            double amount = s.nextDouble();
            sims[selection - 1].topUp(amount);
        }
    }
    private void tariffChanger(){
        if (isOn == true){
            display.showDisplay("Select a sim you would like to use : 1 or 2");
            int simSel = s.nextInt();
            if (simSel <= 2 && simSel != 0){
                display.showDisplay("Select a tariff. Enter a number : 1 - tariff1, 2 - tariff2, 3 - tariff3");
                int sel = s.nextInt();
                display.showDisplay("Enter a new tariff price for tariff" + sel);
                double newTariffPrice = s.nextDouble();
                sims[simSel - 1].tariffChanger(sel, newTariffPrice);
            }
        }
    }
}
