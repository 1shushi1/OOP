package multithreading.basic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       Thread mainThread = Thread.currentThread();
        System.out.println(mainThread);
        mainThread.setName("Ivan");
        mainThread.setPriority(Thread.MIN_PRIORITY);
        System.out.println(mainThread);
//        try {
//            Thread.sleep(10000);
////            mainThread.sleep(10000);
//            System.out.println("Finish");
//        } catch (InterruptedException e){
//        }

        PrintingThread object1 = new PrintingThread("Vasya", 10);
        PrintingThread object2 = new PrintingThread("Ivan", 9);
        PrintingThread object3 = new PrintingThread("Kolya", 5);
        Timer timer = new Timer(10);
        Thread timerThread = new Thread(timer);

        object1.start();
        object2.start();
        object3.start();
        timerThread.start();
        try {
            object1.join();
            object2.join();
            object3.join();
            System.out.println("main finished");
        } catch (InterruptedException e){
        }
    }
}
