package interfaces.display;

import java.util.ArrayList;
import java.util.Scanner;
public class Computer {
    private ArrayList<Display> displays = new ArrayList<>();
    private ArrayList<Usb> usbConnections = new ArrayList<>();
    public void connectDisplay(Display display){
        displays.add(display);
        System.out.println("You've successfully connected display");
    }
    public void removeDisplay(){
        System.out.println("Select a display you would like to remove");
        listOfDisplays();
        Scanner s = new Scanner(System.in);
        int sel = s.nextInt();
        displays.remove(sel);
        System.out.println("You've successfully remove a device");
    }
    public void listOfDisplays(){
        for (int i = 0; i <displays.size() ; i++) {
            System.out.println(i + " - " +  displays.get(i).getClass().getSimpleName());
        }
    }
    public void usbConnect(Usb usb){
        usbConnections.add(usb);
        for (int i = 0; i < displays.size(); i++) {
            displays.get(i).display(usb.getData());
        }
    }
}
