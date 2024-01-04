package statics.simple;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Sasha",   Human.RACE2, EyeColor.BLUE);
        Human human2 = new Human("Raf", Human.RACE1, EyeColor.GREEN);
        human1.info();
        human2.info();

    }
}
