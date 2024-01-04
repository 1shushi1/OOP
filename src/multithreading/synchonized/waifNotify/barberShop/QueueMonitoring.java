package multithreading.synchonized.waifNotify.barberShop;

public class QueueMonitoring extends Thread{
    private BarberShop barberShop;
    public QueueMonitoring(BarberShop barberShop){
        this.barberShop = barberShop;
    }
    @Override
    public void run(){
        while(true){
            try {

            } catch (InterruptedException e){
            }
        }
    }
}
