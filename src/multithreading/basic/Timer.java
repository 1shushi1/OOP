package multithreading.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Timer implements Runnable{
    private int iterationTime;
    public Timer(int iterationTime){
        this.iterationTime = iterationTime;
    }
    @Override
    public void run(){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        for (int i = 0; i < iterationTime; i++) {
            System.out.println(format.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
        }
    }
}
