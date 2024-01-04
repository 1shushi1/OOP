package multithreading.synchonized.carFactory;

import java.io.BufferedWriter;

public class TowBoat extends Thread{
    private BufferedWriter writer;
    private Ship ship;
    public TowBoat(BufferedWriter writer, Ship ship){
        this.writer = writer;
        this.ship = ship;
    }
    @Override
    public void run(){
        while (true) {
            try {
                sleep(3000);
                if (ship.getCarsSize() == ship.getShipSize()) {
                    ship.clear();
                }
            } catch (InterruptedException e){
            }
        }
    }
}

