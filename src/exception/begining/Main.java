package exception.begining;

public class Main {
    public static void main(String[] args) {
        try {
            first();
        } catch (NullPointerException e){
            System.out.println("Caught in method main");
        } catch (ArithmeticException e){
            System.out.println("Arithmetic exception");
        } catch (AlexException e){
            System.out.println("Alex exception");
        }
        System.out.println("After first");
    }
    public static void first(){
        second();
        System.out.println("After second");
    }
    public static void second(){
        First first = new First();
        first.third();
        int firstNum = 0;
        int secondNum = 20;
        secondNum = secondNum/firstNum;
        System.out.println("Second number = " + secondNum);
    }
}
