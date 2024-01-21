package generics.animal;

public class Dog extends Animal{
    public Dog(String name, String breed, String gender){
        super(name, breed, gender);
    }
    @Override
    public void voice(){
        System.out.println("Waf-waf");
    }
}
