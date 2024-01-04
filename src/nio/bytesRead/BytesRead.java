package nio.bytesRead;

import task7.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class BytesRead {
    public static void main(String[] args) {
        try {
            Path path = Path.of("Files/Photos/first.jpg");
            byte[] arr = Files.readAllBytes(path);
            System.out.println(Arrays.toString(arr));
        } catch (IOException e){
        }
    }
}
