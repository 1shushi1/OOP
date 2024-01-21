package lambdas;

@FunctionalInterface

public interface Action3 {
     void execute1();
//    abstract void execute2();
     default void defaultMethod(){
          System.out.println("Default method");
     }
     static void staticMethod(){
          System.out.println("Static method");
     }
}
