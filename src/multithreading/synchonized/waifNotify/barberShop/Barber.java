package multithreading.synchonized.waifNotify.barberShop;

public class Barber extends Thread {
    private int barberID;
    public Barber(int barberID){
        this.barberID = barberID;
    }
}
