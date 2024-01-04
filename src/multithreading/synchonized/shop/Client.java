package multithreading.synchonized.shop;

import javax.naming.Name;
import java.util.Random;

public class Client extends Thread{
    private Shop shop;
    public Client(String name, Shop shop){
        setName(name);
        this.shop = shop;
    }
    @Override
    public void run(){
        Random r = new Random();
        while (true) {
            String brand = null;
            int num1 = r.nextInt(3);
            if (num1 == 0){
                brand = "Apple";
            } else if (num1 == 1){
                brand = "Samsung";
            } else {
                brand = "Xiaomi";
            }
            String type = null;
            int num2 = r.nextInt(3);
            if (num2 == 0) {
                type = "Phone";
            } else if (num2 == 1) {
                type = "Laptop";
            } else {
                type = "Earphones";
            }
            Product product = shop.sellProduct(brand, type, getName());
            System.out.println((product!=null) ? getName() + " received a " + product : getName() + " asked for : " +
                    brand + " - " + type +"\n But not received requested product");
            try {
                sleep(r.nextInt((3-1)+1)*1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
