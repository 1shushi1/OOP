package multithreading.synchonized.waifNotify.barberShop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("barberShop.txt")))) {

            BarberShop barberShop = new BarberShop(2, 5, writer);

            ClientGenerator clientGenerator1 = new ClientGenerator(barberShop, 1, 4, 1, 3);
            ClientGenerator clientGenerator2 = new ClientGenerator(barberShop, 1, 3, 1, 3);
            ClientGenerator clientGenerator3 = new ClientGenerator(barberShop, 1, 2, 1, 3);

            clientGenerator1.setDaemon(true);
            clientGenerator2.setDaemon(true);
            clientGenerator3.setDaemon(true);

            clientGenerator1.start();
            clientGenerator2.start();
            clientGenerator3.start();

            Thread.sleep(40000);

            writer.append("Amount of generated clients : " + ClientGenerator.getID() +
                    "\nAmount of clients who didn't have enough places in the queue : " + barberShop.getAmountOfClientsWhoDoesntHavePlace() +
                    "\nAmount of clients who waited more than 4 seconds and leave without cutting : " + barberShop.getAmountOfClientsWhoWaitedButWasNotCut() +
                    "\nAverage cutting time : " + barberShop.getGeneralCuttingTime() / barberShop.getAmountOfClientsWhoWasCut() +
                    "\nAmount of clients who was cut : " + barberShop.getAmountOfClientsWhoWasCut() +
                    "\nAmount of clients who was still cutting after program finished : " + barberShop.findAmountOfClientsWhoWasStillCuttingAfterProgFinished() +
                    "\nAverage waiting time in a queue : " + barberShop.getGeneralWaitingTime() / (barberShop.getAmountOfClientsWhoWaitedButWasNotCut()) + barberShop.getAmountOfClientsWhoWasCut()
                    + barberShop.getAmountOfClientsWhoWasStillCuttingAfterProgFinished() + "\n");
            System.out.println("Amount of generated clients : " + ClientGenerator.getID() +
                    "\nAmount of clients who didn't have enough places in the queue : " + barberShop.getAmountOfClientsWhoDoesntHavePlace() +
                    "\nAmount of clients who waited more than 4 seconds and leave without cutting : " + barberShop.getAmountOfClientsWhoWaitedButWasNotCut() +
                    "\nAverage cutting time : " + barberShop.getGeneralCuttingTime() / barberShop.getAmountOfClientsWhoWasCut() +
                    "\nAmount of clients who was cut : " + barberShop.getAmountOfClientsWhoWasCut() +
                    "\nAmount of clients who was still cutting after program finished : " + barberShop.findAmountOfClientsWhoWasStillCuttingAfterProgFinished() +
                    "\nAverage waiting time in a queue : " + barberShop.getGeneralWaitingTime() / (barberShop.getAmountOfClientsWhoWaitedButWasNotCut()) + barberShop.getAmountOfClientsWhoWasCut()
                    + barberShop.getAmountOfClientsWhoWasStillCuttingAfterProgFinished());
        } catch (IOException | InterruptedException e) {
        }
    }
}
