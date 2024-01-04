package multithreading.synchonized.method;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Synch {
    private BufferedWriter writer;
    public Synch(){
        try {
            writer = new BufferedWriter(new FileWriter(new File("methodWay.txt")));
        } catch (IOException e){
        }
    }
    public synchronized void write(String name){
        for (int i = 0; i < 3; i++) {
            try {
                writer.append(i + ". " + name);
                try {
                    Thread.sleep(1000);
                    writer.append("  ->  " + i + ". " + name + "\n");
                } catch (InterruptedException e){
                }
            } catch (IOException e){
            }
        }
    }
    public void close(){
        try{
            writer.close();
        } catch (IOException e){
        }
    }
}
