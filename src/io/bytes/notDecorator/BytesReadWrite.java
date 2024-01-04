package io.bytes.notDecorator;

import java.io.*;
import java.util.Arrays;

public class BytesReadWrite {
    public static void main(String[] args) {
        byte [] photo = null;
        BufferedInputStream input = null;
        ByteArrayOutputStream output = null;
        try {
            input = new BufferedInputStream(new FileInputStream(new File("photo.HEIC")));
            output = new ByteArrayOutputStream();
            int a = 0;
            while ((a = input.read()) != -1){
                output.write(a);
            }
            photo = output.toByteArray();
            System.out.println(Arrays.toString(photo));
        } catch (IOException e){
        }
        finally{
            try {
                input.close();
                output.close();
            } catch (IOException e){

            }
        }
    }
}
