package exception.apartment;

import java.util.Scanner;

public class Domophone {
    private Display display = new Display();
    private Scanner s = new Scanner(System.in);
    private Building.Controller controller;
    public void call(){
        try {
        System.out.println("Enter an apartment number you would like to call");
        int apartmentNumber = s.nextInt();
        if (controller != null){
            controller.analyze(apartmentNumber);
        }
        } catch (SpeakerException e){
            display.showData(e.getApartmentNumber(), e.getOwner());
        }
        call();
    }
    public void connector(Building.Controller controller){
        this.controller = controller;
        call();
    }
}
