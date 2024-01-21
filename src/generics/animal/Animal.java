package generics.animal;

public abstract class Animal {
    private String name;
    private String breed;
    private String gender;
    public Animal(String name, String breed, String gender){
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }
    public abstract void voice();
}
