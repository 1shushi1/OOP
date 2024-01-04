package io.bytes.objectIO;

import io.bytes.data.ProductController;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Sim sim1 = new Sim("+380968478479", "Kyivstar", 0.1, 0.2, 10);
        Sim sim2 = new Sim("+380668478479", "Vodafone", 0.2, 0.3, 20);
        ArrayList<Sim> simCards = new ArrayList<>();
        Collections.addAll(simCards, sim1, sim2);
        Phone phone1 = new Phone("Apple", simCards, "IPhone 15 Pro Max", PhoneController.getPhoto("8395864.jpg"),
                1500, 12938712983713L);
        Phone phone2 = new Phone("Samsung", simCards, "15 Ultra Pro", PhoneController.getPhoto("8395864.jpg"),
                1200, 987918723948734L);
        Phone phone3 = new Phone("Xiaomi", simCards, "PRO3000", PhoneController.getPhoto("8395864.jpg"),
                700, 19238719283798L);
        Phone phone4 = new Phone("Apple", simCards, "IPhone 14 Pro", PhoneController.getPhoto("8395864.jpg"),
                1300, 129831092310923L);
//
//        boolean ans = PhoneControllerList.save(phone1);
//        boolean ans1 = PhoneControllerList.save(phone2);
//        boolean ans2= PhoneControllerList.save(phone3);
//        boolean ans3 = PhoneControllerList.save(phone4);
////
//        System.out.println(ans);
//        System.out.println(ans1);
//        System.out.println(ans2);
//        System.out.println(ans3);

//        System.out.println(PhoneControllerList.findAll());

//        boolean ans = PhoneControllerList.delete(phone1);
//        System.out.println(ans);
//
//        System.out.println(PhoneControllerList.findAll());

//        ArrayList<Phone> foundPhones = PhoneController.findAll();
//        System.out.println(foundPhones);

        boolean ans = PhoneControllerList.update(phone2, phone1);
        System.out.println(ans);

        System.out.println(PhoneControllerList.findAll());
    }
}
