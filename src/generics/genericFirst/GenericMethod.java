package generics.genericFirst;

public class GenericMethod {
    public <T> void sayHello(T t){
        System.out.println("Generic method : " + t);
    }
}
