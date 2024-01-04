package multithreading.synchonized.block;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class Synhro {
    private BufferedWriter writer;
     public Synhro(){
         try {
             writer = new BufferedWriter(new FileWriter(new File("text.txt")));
         } catch (IOException e){
         }
     }
     public void print(String text){
         try {
             writer.append(text);
         } catch (IOException e){
         }
     }
     public void close(){
         try {
             writer.close();
         } catch (IOException e){
         }
     }
}
