package multithreading.synchonized.block;

public class PrintingThread extends Thread{
    private String name;
    private int iterationTime;
    private Synhro synhro;
    public PrintingThread(String name, int iterationTime, Synhro synhro){
        this.name = name;
        this.iterationTime = iterationTime;
        this.synhro = synhro;
    }
    @Override
    public void run(){
        synchronized (synhro) {
            for (int i = 0; i < iterationTime; i++) {
                synhro.print(i + ". " + name);
                try {
                    Thread.sleep(1000);
                    synhro.print(" ->   " + i + ". " + name + "\n");
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
