package inheritance.basicInfo;

public abstract class Fish extends Animal{
    private boolean isPredator;
    public Fish(boolean isPredator, String name, String type, String color, double weight, int size){
        super(name, type, color, weight, size);
        this.isPredator = isPredator;
    }
    public boolean isPredator(){
        return isPredator;
    }
    public void swim(double depth){
        System.out.println("Fish is swimming in " + depth + "m");
    }
    public void voice(){
        System.out.println("Bul-bul");
    }
}
