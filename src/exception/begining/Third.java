package exception.begining;

import java.util.Random;

public class Third {
    public void fifth() throws HandleException{
        try {
            HandleExample handleExample = new HandleExample();
            handleExample.firstMethod();
            Random r = new Random();
            int answer = r.nextInt(3);
            if (answer == 0) {
                AlexException alexException = new AlexException();
                throw alexException;
            } else if (answer == 1){
                System.out.println("Code was compiled without exceptions");
            } else {
                throw new ArithmeticException();
            }
        } finally {
            importantMethod();
        }
    }
    public void importantMethod(){
        System.out.println("Logic of the important method");

    }
}
