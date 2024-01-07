package multithreading.synchonized.waifNotify.barberShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BarberShop {
    private ArrayList<Barber> barbers = new ArrayList<>();
    private ArrayList<Client> queue = new ArrayList<>();
    private BufferedWriter writer;
    private int maxQueueSize;
    private int amountOfClientsWhoDoesntHavePlace;
    private int amountOfClientsWhoWaitedButWasNotCut;
    private int amountOfClientsWhoWasCut;
    private int amountOfClientsWhoWasStillCuttingAfterProgFinished;
    private int generalCuttingTime;
    private int generalWaitingTime;
    private int amountOfClientsWhoEnteredBarber;

    public BarberShop(int barbersAmount, int maxQueueSize, BufferedWriter writer) {
        this.writer = writer;
        this.maxQueueSize = maxQueueSize;
        for (int i = 0; i < barbersAmount; i++) {
            Barber barber = new Barber(i++, 1, new Random().nextInt(5 - 2) + 2);
            barber.setDaemon(true);
            barbers.add(barber);
            barber.start();
        }
        QueueMonitoring queueMonitoring = new QueueMonitoring();
        queueMonitoring.setDaemon(true);
        queueMonitoring.start();
    }

    public synchronized void receivedClient(ArrayList<Client> clients) {
        try {
            if (queue.size() == maxQueueSize) {
                writer.append("There is no spaces in the queue." + clients.size() + " left without waiting\n");
                System.out.println("There is no spaces in the queue." + clients.size() + " left without waiting");
                amountOfClientsWhoDoesntHavePlace += clients.size();
                clients.clear();
                wait();
            }
            int amountOfFreeSpacesInAQueue = maxQueueSize - queue.size();
            int clientsToLeave = clients.size() - amountOfFreeSpacesInAQueue;
            if (clientsToLeave >= 0){
                amountOfClientsWhoDoesntHavePlace += clientsToLeave;
                System.out.println("Clients to leave : " + clientsToLeave);
            }
            for (int i = clients.size() - 1; i >= 0; i--) {
                if (queue.size() < maxQueueSize) {
                    Client client = clients.remove(0);
                    queue.add(client);
                    System.out.println("Client with id : " + client.getId() + " entered a queue");
                    writer.append("Client with id : " + client.getId() + " entered a queue\n");
                } else {
                    clients.clear();
                    wait();
                }
            }
            notifyAll();
        } catch (IOException | InterruptedException e) {
        }
    }

    public class Barber extends Thread {
        private int barberID;
        private int cuttingTimeFrom;
        private int cuttingTimeTo;

        public Barber(int barberID, int cuttingTimeFrom, int cuttingTimeTo) {
            this.barberID = barberID;
            this.cuttingTimeFrom = cuttingTimeFrom;
            this.cuttingTimeTo = cuttingTimeTo;
        }

        @Override
        public void run() {
            Random r = new Random();
            while (true) {
                try {
                    int cuttingTime = r.nextInt(cuttingTimeTo - cuttingTimeFrom) + cuttingTimeFrom;
                    Client client = takeClient();
                    generalWaitingTime += System.currentTimeMillis() - client.getEnteringTime();
                    writer.append(client.getId() + " barber took a client from the queue\n");
                    System.out.println(client.getId() + " barber took a client from the queue");
                    amountOfClientsWhoEnteredBarber++;
                    sleep(cuttingTime * 1000);
                    amountOfClientsWhoWasCut++;
                    generalCuttingTime += cuttingTime;
                    writer.append("Client was cut");
                    System.out.println("Client was cut");
                } catch (InterruptedException | IOException e) {
                }
            }
        }
    }

    public class QueueMonitoring extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    searchInQueue();
                    sleep(4000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public int getAmountOfClientsWhoDoesntHavePlace() {
        return amountOfClientsWhoDoesntHavePlace;
    }

    public int getAmountOfClientsWhoWaitedButWasNotCut() {
        return amountOfClientsWhoWaitedButWasNotCut;
    }

    public int getGeneralCuttingTime() {
        return generalCuttingTime;
    }

    public int getAmountOfClientsWhoWasCut() {
        return amountOfClientsWhoWasCut;
    }

    public int getGeneralWaitingTime() {
        return generalWaitingTime;
    }

    public int getAmountOfClientsWhoWasStillCuttingAfterProgFinished() {
        return amountOfClientsWhoWasStillCuttingAfterProgFinished;
    }

    public int findAmountOfClientsWhoWasStillCuttingAfterProgFinished() {
        return amountOfClientsWhoWasStillCuttingAfterProgFinished = amountOfClientsWhoWasCut - amountOfClientsWhoEnteredBarber;
    }

    public synchronized Client takeClient() {
        Client client = null;
        try {
            if (queue.isEmpty()) {
                wait();
            }
            client = queue.get(0);
            notifyAll();
        } catch (InterruptedException e) {
        }
        return client;
    }

    public synchronized void searchInQueue() {
        try {
            if (queue.isEmpty()) {
                wait();
            }
            for (int i = queue.size() - 1; i >= 0; i--) {
                Client client = queue.get(i);
                if (client.getEnteringTime() >= 4 * 1000) {
                    generalWaitingTime += System.currentTimeMillis() - client.getEnteringTime();
                    if (queue.remove(i) != null){
                        amountOfClientsWhoWaitedButWasNotCut++;
                    }
                    writer.append(client + " waiting for : " + (System.currentTimeMillis() - client.getEnteringTime()) / 1000.0 + " and left a queue\n");
                    System.out.println(client + " waiting for : " + (System.currentTimeMillis() - client.getEnteringTime()) / 1000.0 + " and left a queue");
                }
            }
            notifyAll();
        } catch (InterruptedException | IOException e) {
        }
    }
}

