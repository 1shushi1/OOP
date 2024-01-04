package forFun;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number you would like to check");
        int num = s.nextInt();
        String ans = numberFinder(num);
        System.out.println(ans);
    }
    public static String numberFinder(int number){
        String evenOdd = ((number % 2) == 0) ? "Number : " + number + " is even" : "Number : " + number + " is odd";
        return evenOdd;
    }
}
