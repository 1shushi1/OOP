package io.text.toyTextIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> legoFitchers = new HashMap<>();
        legoFitchers.put("Panel", 5);
        legoFitchers.put("Wheel", 4);
        legoFitchers.put("Bricks", 250);
        legoFitchers.put("Roof", 1);
        legoFitchers.put("Window", 5);

        HashMap<String, Integer> dollFitchers = new HashMap<>();
        dollFitchers.put("Doll", 1);
        dollFitchers.put("Hair Brush", 1);
        dollFitchers.put("Shoes", 2);
        dollFitchers.put("Dress", 2);

        HashMap<String, Integer> toyGun = new HashMap<>();
        toyGun.put("Soft Bullets", 20);
        toyGun.put("Nerf Gun", 1);
        toyGun.put("Scope", 2);
        toyGun.put("Holder", 1);

        Toy toy1 = new Toy("Lego Police Constructor", 243, "Lego", legoFitchers, 7, "Plastic");
        Toy toy2 = new Toy("Barbie Doll", 153, "Barbie", dollFitchers, 3, "Plastic");
        Toy toy3 = new Toy("Toy Gun", 123, "NERF", toyGun, 9, "Plastic");

//        boolean ans1 = ToysController.save(toy1);
//        boolean ans2 = ToysController.save(toy2);
//        boolean ans3 = ToysController.save(toy3);
//
//        System.out.println(ans1);
//        System.out.println(ans2);
//        System.out.println(ans3);
//        ArrayList<Toy> toys = ToysController.findAll();
//        for (int i = 0; i < toys.size(); i++) {
//            System.out.println(toys.get(i));
//        }

//        boolean ans = ToysController.delete(toy1);
//        System.out.println(ans);
//        boolean ans = ToysController.update(toy2, toy1);
//        System.out.println(ans);

//        ArrayList<Toy> toys = new ArrayList<>();
//        Collections.addAll(toys, toy1, toy2, toy3);
//
//        boolean ans = ToysController.saveAll(toys);
//        System.out.println(ans);

//        ArrayList<Toy> toys = ToysController.find(4, 8);
//        System.out.println(toys);
    }
}
