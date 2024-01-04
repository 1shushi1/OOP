package multithreading.basic;

public class PrintingThread extends Thread{
    private String name;
    private int iterationTimes;
    public PrintingThread(String name, int iterationTimes){
        this.name = name;
        this.iterationTimes = iterationTimes;
    }

    @Override
    public void run(){
        for (int i = 0; i < iterationTimes; i++) {
            System.out.println(i + ". " +  name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
        }
    }
}
