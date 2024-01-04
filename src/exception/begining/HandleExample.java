package exception.begining;

import java.util.Random;

public class HandleExample {
    public void firstMethod() throws HandleException{
        Random r = new Random();
        boolean ans = r.nextBoolean();
        if (ans == true){
            HandleException handleException = new HandleException("Hello world!");
            throw handleException;
        }
    }
}
