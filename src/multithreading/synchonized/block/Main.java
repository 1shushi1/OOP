package multithreading.synchonized.block;

public class Main {
    public static void main(String[] args) {

        Synhro synhro = new Synhro();

        PrintingThread ob1 = new PrintingThread("Vasya", 10, synhro);
        PrintingThread ob2 = new PrintingThread("Sasha", 9, synhro);
        PrintingThread ob3 = new PrintingThread("Tolya", 4, synhro);



        ob1.start();
        ob2.start();
        ob3.start();

        try {
            ob1.join();
            ob2.join();
            ob3.join();
            synhro.close();
        } catch (InterruptedException e){
        }
    }
}
