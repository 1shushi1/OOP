package multithreading.synchonized.method;

public class PrintThread extends Thread{
    private String name;
    private int iterationTimes;
    private Synch synch;
    public PrintThread(String name, int iterationTimes, Synch synch){
        this.name = name;
        this.iterationTimes = iterationTimes;
        this.synch = synch;
    }
    @Override
    public void run(){
        for (int i = 0; i < iterationTimes; i++) {
            synch.write(name);
        }
    }
}
