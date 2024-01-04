package inheritance.homeDevice;

import java.util.ArrayList;
import java.util.Collections;

public class Radio extends Device{
    private int maxVolume = 100;
    private int minVolume = 0;
    private int volume;
    private ArrayList<Double> radioWaves;
    private int currentPos = 0;
    public Radio(int volume){
        this.volume = volume;
        radioWaves = new ArrayList<>();
        Collections.addAll(radioWaves, 109.7, 98.6, 88.8, 106.3, 102.1, 99.7);
    }
    @Override
    public void left(){
        if (minVolume > volume){
            volume--;
        }
        System.out.println("You've decrease volume");
    }
    @Override
    public void right(){
        if (maxVolume < volume){
            volume++;
        }
        System.out.println("You've increase volume");
    }
    @Override
    public void up(){
        if (currentPos < radioWaves.size() - 1){
            currentPos++;
        } else {
            currentPos = 0;
        }
        System.out.println("You've turned on : " + radioWaves.get(currentPos) + " wave");
    }
    public void down(){
        if (currentPos > 0){
            currentPos--;
        } else {
            currentPos = radioWaves.size() - 1;
        }
        System.out.println("You've turned on : " + radioWaves.get(currentPos) + " wave");
    }
}
