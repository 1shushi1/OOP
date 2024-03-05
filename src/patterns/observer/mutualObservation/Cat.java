package patterns.observer.mutualObservation;


import java.util.ArrayList;
import java.util.List;

public class Cat implements Observer {
    @Override
    public void update(Observable o) {
        if (o instanceof Dog){
            playWithDog();
        } else {
            Human human = (Human) o;
            if (human.getCounter() == 0) {
            meow();
            }
        }
    }

    public void meow() {
        System.out.println("Cat is meowing");
    }

    public void playWithDog() {
        System.out.println("Cat is playing with dog");
    }
}
