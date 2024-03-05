package patterns.observer.mutualObservation;


import java.util.ArrayList;
import java.util.List;

public class Human implements Observer, Observable{
    List<Observer> observers = new ArrayList<>();
    private int counter = 0;
    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }
    @Override
    public void notifyObservers(){
        for (Observer o : observers){
            o.update(this);
        }
    }
    @Override
    public void update(Observable o){
        if (o instanceof Dog){
            Dog dog = (Dog) o;
            if (dog.getCounter() == 1){
                isTellingNotToBark();
            }
        }
    }
    public void eat(){
        System.out.println("Human eats");
        notifyObservers();
        counter++;
    }
    public void isTellingNotToBark(){
        System.out.println("Human tells dog not to bark");
        notifyObservers();
    }
    public int getCounter(){
        return counter;
    }
//    public void petTheCat(){
//        System.out.println("Petting a cat");
//    }
//    public int getIsTellingNotToBark(){
//        return isTellingNotToBark();
//    }
}
