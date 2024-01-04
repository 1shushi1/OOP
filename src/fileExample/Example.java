package fileExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Example {
    public static void main(String[] args) {
        String path = "/Users/user/output-onlinefiletools.txt";
        String text = fileToString(path);
        String newText = addSpaces(text);
        System.out.println(newText);
    }
    public static String addSpaces(String text){
        String a = "";
        a = text.replace(" ", "  ");
        return a;
    }
    public static String fileToString(String path){
        try {
            String component = Files.readString(Paths.get(path));
            return component;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
