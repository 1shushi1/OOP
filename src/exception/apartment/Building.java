package exception.apartment;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Building{
    private Controller controller = new Controller();
    private Scanner s = new Scanner(System.in);
    private ArrayList<ArrayList<Apartment>> apartments = new ArrayList<>();
    public Building(){
        ArrayList<String> ownerNames = new ArrayList<>();
        ownerNames.add("Vasya");
        ownerNames.add("Sasha");
        ownerNames.add("Tolya");
        ownerNames.add("Masha");
        ownerNames.add("Kolya");
        Random r = new Random();
        System.out.println("Enter an amount of floors your building would have");
        int amountOfFloors = s.nextInt();
        for (int i = 1; i <= amountOfFloors; i++){
            ArrayList<Apartment> floor = new ArrayList<>();
            System.out.println("Enter an amount of apartments of a floor : " + i + "?");
            int apartmentsOnFloor = s.nextInt();
            for (int j = 0; j < apartmentsOnFloor; j++) {
                int apartmentsNumber = (i*1) * 10 + (j+1);
                int randomSel = r.nextInt(ownerNames.size());
                floor.add(new Apartment(ownerNames.get(randomSel), apartmentsNumber));
            }
            apartments.add(floor);
        }
    }
    public void connectDomophone(Domophone domophone){
        domophone.connector(controller);
    }
    class Controller{
        public void analyze(int apartmentNumber) throws SpeakerException{
            for (int i = 0; i < apartments.size(); i++) {
                ArrayList<Apartment> floor = apartments.get(i);
                for (int k = 0; k < floor.size(); k++) {
                    if (floor.get(k).getApartmentNumber() == apartmentNumber){
                        floor.get(k).call();
                    }
                }
            }
        }
    }
}

