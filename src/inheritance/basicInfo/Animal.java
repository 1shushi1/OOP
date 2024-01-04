package inheritance.basicInfo;

public abstract class Animal {
    private String name;
    private String type;
    private String color;
    private double weight;
    private int size;
    public Animal(String name, String type, String color, double weight, int size){
        this.name = name;
        this.type = type;
        this.color = color;
        this.weight = weight;
        this.size = size;
    }
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public double getWeight() {
        return weight;
    }
    public int getSize() {
        return size;
    }
    public String getName(){
        return name;
    }
    public void info(){
        System.out.println("Name " + name + ". Type : " + type + ". Color : " + color + ". Weight : " + weight + ". Size : " + size);
    }
    @Override
    public String toString(){
        return "Name " + name + ". Type : " + getClass().getSimpleName() + ". Color : " + color + ". Weight : " + weight + ". Size : " + size;
    }
    public abstract void voice();
    public void toEat(){
        System.out.println(getClass().getSimpleName() + " is eating");
    }
}
