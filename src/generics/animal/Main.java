package generics.animal;

public class Main {
    public static void main(String[] args) {
        GenericZoo <Animal> genericZoo1 = new GenericZoo<>();
        GenericZoo <Cat> genericZoo2 = new GenericZoo<>();
        GenericZoo <Dog> genericZoo3 = new GenericZoo<>();
        genericZoo1.add(new Cat("Sindy", "Sphinks", "Female"));
        genericZoo1.add(new Dog("Mike", "Yorkshire", "Male"));
        genericZoo1.voice();
    }
}
