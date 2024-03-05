package patterns.observer.mutualObservation;


import java.util.ArrayList;
import java.util.List;

public class Dog implements Observer, Observable {
    List<Observer> observer = new ArrayList<>();
    private int counter = 0;

    @Override
    public void addObserver(Observer o) {
        observer.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observer.remove(o);
    }

    @Override
    public void notifyObservers() {
        observer.forEach(e -> e.update(this));
    }

    @Override
    public void update(Observable o) {
        if (o instanceof Human) {
            if (counter == 0) {
                counter++;
                bark();
            } else {
                counter = 0;
                stopBarking();
            }
        }
    }

    public void bark() {
        System.out.println("Dog is barking");
        notifyObservers();
    }
    public void playWithCat(){
        System.out.println("Dog playing with cat");
        notifyObservers();
    }

    public void stopBarking() {
        System.out.println("Dog stopped barking");
    }

    public int getCounter() {
        return counter;
    }
}
