package exception.begining;

import java.util.Arrays;

public class First {
    public void third(){
        try {
            Second second = new Second();
            second.fourth();
            int [] arr = new int[5];
            arr[5] = 5;
            System.out.println(Arrays.toString(arr));
        } catch (HandleException e){
            System.out.println("Caught in class first method" + " " + e.getMessage());
        }
    }
}
