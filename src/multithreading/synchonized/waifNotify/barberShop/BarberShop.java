package multithreading.synchonized.waifNotify.barberShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BarberShop extends Thread {
    private ArrayList<Barber> barbers = new ArrayList<>();
    private ArrayList<Client> queue = new ArrayList<>();
    private BufferedWriter writer;
    private int maxQueueSize;
    private int cuttingTimeFrom;
    private int cuttingTimeTo;
    private long waitingTime;
    private int amountOfClientWhoDoesntHavePlace; //clients which was generated, put into an array list, but they hadn't had free space at the queue


    public BarberShop(int barbersAmount, int maxQueueSize, BufferedWriter writer) {
        this.writer = writer;
        this.maxQueueSize = maxQueueSize;
        for (int i = 0; i < barbersAmount; i++) {
            barbers.add(new Barber(i++));
        }
    }

    public synchronized void receivedClient(ArrayList<Client> clients) {
        int amountOfClientsWhoEnteredAQueue = 0;
        try {
            if (queue.size() == maxQueueSize){
                writer.append("There is no spaces in the queue." + clients.size() + " left without waiting\n");
                System.out.println("There is no spaces in the queue." + clients.size() + " left without waiting");
                amountOfClientWhoDoesntHavePlace += clients.size();
                clients.clear();
                wait();
            }
            for (int i = clients.size() - 1; i >= 0; i--) {
                if (queue.size() < maxQueueSize){
                    queue.add(clients.remove(0));
                    
                    amountOfClientsWhoEnteredAQueue += 1;
                } else {
                    amountOfClientWhoDoesntHavePlace += clients.size();
                    clients.clear();
                    wait();
                }
            }
            writer.append("Amount of clients who entered a queue : " + amountOfClientsWhoEnteredAQueue +
                    "\nAmount of clients who doesn't enetered a queue : " + amountOfClientWhoDoesntHavePlace + "\n");
            System.out.println("Amount of clients who entered a queue : " + amountOfClientsWhoEnteredAQueue +
                    "\nAmount of clients who doesn't enetered a queue : " + amountOfClientWhoDoesntHavePlace);
        } catch (IOException | InterruptedException e){
        }
    }
}
