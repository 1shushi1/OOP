package multithreading.synchonized.method;

public class Main {
    public static void main(String[] args) {
        Synch synch = new Synch();

        PrintThread object1 = new PrintThread("Vasya", 5, synch);
        PrintThread object2 = new PrintThread("Kolya", 7, synch);
        PrintThread object3 = new PrintThread("Sasha", 10, synch);

        object1.start();
        object2.start();
        object3.start();

        try {
            object1.join();
            object2.join();
            object3.join();
            synch.close();
        } catch (InterruptedException e){
        }
    }
}
