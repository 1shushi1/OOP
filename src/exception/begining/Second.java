package exception.begining;

public class Second {
    public void fourth() throws HandleException {
        Third third = new Third();
        third.fifth();
//        try {
            String text = null;
            System.out.println(text.length());
//        } catch (NullPointerException e) {
//            System.out.println("Caught in method fourth");
//        }
//        System.out.println("After fourth");
    }
}
