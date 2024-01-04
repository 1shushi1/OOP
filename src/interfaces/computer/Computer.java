package interfaces.computer;

import java.util.ArrayList;
import java.util.Scanner;

public class Computer {
    private Scanner s = new Scanner(System.in);
    private ArrayList<Printable> printables = new ArrayList<>();
    private int indexOfActivePrinter = -1;

    public void addPrinter(Printable p){
        printables.add(p);
        System.out.println("You've successfully added a new device");
    }
    public void removePrinter(){
        listOfPrinters();
        System.out.println("Select a device to remove from the list ( enter a number )");
        int sel = s.nextInt();
        printables.remove(sel);
        System.out.println("You've successfully remove a device");
    }
    public void listOfPrinters(){
        for (int i = 0; i < printables.size() ; i++) {
            System.out.println(i + " - " + printables.get(i).getClass().getSimpleName());
        }
    }
    public void selectPrinter(){
        System.out.println("Select printer you would like to use");
        listOfPrinters();
        indexOfActivePrinter = s.nextInt();
    }
    public void printMessage(String message){
        if (indexOfActivePrinter != -1) {
            printables.get(indexOfActivePrinter).print(message);
        } else {
            System.out.println("Select printer before printing");
        }
    }
}
