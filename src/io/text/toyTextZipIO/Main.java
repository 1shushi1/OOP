package io.text.toyTextZipIO;

import io.text.toyTextIO.Toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> legoDetails = new HashMap<>();
        legoDetails.put("Panel", 5);
        legoDetails.put("Wheel", 4);
        legoDetails.put("Bricks", 250);
        legoDetails.put("Roof", 1);
        legoDetails.put("Window", 5);

        HashMap<String, Integer> dollDetails = new HashMap<>();
        dollDetails.put("Doll", 1);
        dollDetails.put("Hair Brush", 1);
        dollDetails.put("Shoes", 2);
        dollDetails.put("Dress", 2);

        HashMap<String, Integer> toyGun = new HashMap<>();
        toyGun.put("Soft Bullets", 20);
        toyGun.put("Nerf Gun", 1);
        toyGun.put("Scope", 2);
        toyGun.put("Holder", 1);

        Toy toy1 = new Toy("Lego Police Constructor", 243, "Lego", legoDetails, 7, "Plastic");
        Toy toy2 = new Toy("Barbie Doll", 153, "Barbie", dollDetails, 3, "Plastic");
        Toy toy3 = new Toy("Toy Gun", 123, "NERF", toyGun, 9, "Plastic");

        ArrayList<Toy> toys = new ArrayList<>();
        Collections.addAll(toys, toy1, toy2, toy3);

//        boolean ans = ToyController.saveAll(toys);
//        System.out.println(ans);

//        ArrayList<Toy> foundToys = ToyController.findAll();
//        System.out.println(foundToys);

//        boolean ans = ToyController.save(toy1);
//        System.out.println(ans);

//        boolean ans = ToyController.update(toy1, toy3);
//        System.out.println(ans);

//        boolean ans = ToyController.delete(toy1);
//        System.out.println(ans);

//        ArrayList<Toy> foundToys = ToyController.find(6);
//        System.out.println(foundToys);

//        ArrayList<String> fitchers = new ArrayList<>();
//        Collections.addAll(fitchers, "Wheel");
//
//        ArrayList<Toy> foundToys = ToyController.find(fitchers);
//        System.out.println(foundToys);
    }
}
