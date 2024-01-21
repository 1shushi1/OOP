package generics.genericFirst;

public class GenericClass<T, E> implements GenericInterface<T>{
    @Override
    public void takeType(T t){
        System.out.println(t);
    }
}
