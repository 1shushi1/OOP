package multithreading.synchonized.waifNotify.barberShop;

import java.util.ArrayList;
import java.util.Random;

public class ClientGenerator extends Thread {
    private BarberShop barberShop;
    private int timeFrom;
    private int timeTo;
    private int amountFrom;
    private int amountTo;
    private static int id = 0;
    public ClientGenerator(BarberShop barberShop, int timeFrom, int timeTo, int amountFrom, int amountTo){
        this.barberShop = barberShop;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.amountFrom = amountFrom;
        this.amountTo = amountTo;
    }
    @Override
    public void run(){
        ArrayList<Client> clients = new ArrayList<>();
        Random random = new Random();
        while (true){
            try {
                int time = random.nextInt(timeTo - timeFrom) + timeFrom;
                int clientAmount = random.nextInt(amountTo - amountFrom) + amountFrom;
                for (int i = 0; i < clientAmount; i++) {
                    clients.add(new Client(id++));
                }
                barberShop.receivedClient(clients);
                sleep(time * 1000);
            } catch (InterruptedException e){
            }
        }
    }
}
