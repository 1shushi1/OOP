package inheritance.basicInfo;

public abstract class Insect extends Animal{
    private int amountOfLegs;
    private boolean isHarmful;
    public Insect(String name, String type, String color, double weight, int size, int amountOfLegs, boolean isHarmful){
        super(name, type, color, weight, size);
        this.amountOfLegs = amountOfLegs;
        this.isHarmful = isHarmful;
    }
    public int getAmountOfLegs(){
        return amountOfLegs;
    }
    public boolean isHarmful(){
        return isHarmful;
    }
    @Override
    public String toString(){
        return super.toString() + ". Amount of legs " + amountOfLegs + ". Harmful : " + isHarmful;
    }
}
