package io.bytes.notDecorator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(new File("photo.HEIC")));
            output = new BufferedOutputStream(new FileOutputStream(new File("photoCopy.HEIC")));
            int a = 0;
            long currentTimeMillis = System.currentTimeMillis();
            while((a = input.read()) != -1){
                output.write(a);
            }
            long currentTime = System.currentTimeMillis();
            currentTime -=  currentTimeMillis;
            System.out.println("Time spend : " + currentTime/1000);
        } catch (IOException e){
        }
        finally {
            try {
                input.close();
                output.close();
            }
            catch (IOException e){
            }
        }
    }
}
