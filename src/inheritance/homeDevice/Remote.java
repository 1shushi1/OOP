package inheritance.homeDevice;

import java.util.ArrayList;
import java.util.Collections;

public class Remote {
    private ArrayList<Device> devices;
    private int currentPosition = 1;
    public Remote(){
        devices = new ArrayList<>();
        Conditioner conditioner = new Conditioner(20);
        Heater heater = new Heater(20);
        Tv tv = new Tv(31, 10);
        Radio radio = new Radio(10);
        Collections.addAll(devices, conditioner, heater, tv, radio);
    }
    public void addDevice(Device device){
        devices.add(device);
        System.out.println("You've successfully add new device to your remote");
    }
    public void delDevice(String name){
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getClass().getSimpleName().equals(name)){
                devices.remove(i);
                return;
            }
            System.out.println("You've successfully remove device from your remote");
        }
    }
    public void selectDevice(String name){
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getClass().getSimpleName().equalsIgnoreCase(name)){
                currentPosition = i;
                break;
            }
        }
    }
    public void onOff(){
        devices.get(currentPosition).isOnOff();
    }
    public void left(){
        devices.get(currentPosition).left();
    }
    public void right(){
        devices.get(currentPosition).right();
    }
    public void up(){
        devices.get(currentPosition).up();
    }
    public void down(){
        devices.get(currentPosition).down();
    }
}
