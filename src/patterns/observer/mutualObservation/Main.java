package patterns.observer.mutualObservation;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Dog dog = new Dog();
        Cat cat = new Cat();

        human.addObserver(cat);
        human.addObserver(dog);

        dog.addObserver(human);

        human.eat();

        System.out.println("___________________________");

        human.removeObserver(cat);
        human.removeObserver(dog);

        dog.addObserver(cat);

        dog.playWithCat();

    }
}
