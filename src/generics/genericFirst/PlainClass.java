package generics.genericFirst;

public class PlainClass implements GenericInterface <String>{
    @Override
    public void takeType(String s1){
        System.out.println(s1);
    }
}
