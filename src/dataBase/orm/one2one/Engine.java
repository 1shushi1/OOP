package dataBase.orm.one2one;

public class Engine extends Entity{
    private String brand;
    private String type;
    private int power;
    private double volume;
    public Engine(long id, String brand, String type, int power, double volume){
        super(id);
        this.brand = brand;
        this.type = type;
        this.power = power;
        this.volume = volume;
    }
    public String getBrand (){
        return brand;
    }
    public String getType(){
        return type;
    }
    public int getPower(){
        return power;
    }
    public double getVolume(){
        return volume;
    }
    public Object getId(){
        return super.getId();
    }
}

