package generics.animal;

public class Cat extends Animal{
    public Cat(String name, String breed, String gender){
        super(name, breed, gender);
    }
    @Override
    public void voice(){
        System.out.println("Mur-myau");
    }
}
