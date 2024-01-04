package inheritance.basicInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Bird penguin = new Penguin(20, -40);
        Animal dove = new Dove(true);
        Grasshopper grasshopper = new Grasshopper(76.2);
        Ant ant = new Ant(false);
        Shark shark = new Shark(350);
        Animal clownFish = new ClownFish(true);
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        Collections.addAll(animalArrayList, penguin, dove, grasshopper, ant, shark, clownFish);
        for (int i = 0; i < animalArrayList.size(); i++) {
            animalArrayList.get(i).info();
        }
        shark.swim(10);
        Fish clownFish1 = (Fish)clownFish;
        clownFish1.swim(15);
        System.out.println(grasshopper);
        Object date = new Date();
        System.out.println(date);
        for (int i = 0; i < animalArrayList.size(); i++) {
            animalArrayList.get(i).voice();
        }
        Penguin penguin1 =(Penguin)penguin;
        penguin1.toEat();
        penguin1.toEat(" fish");
    }
}
