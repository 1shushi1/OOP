package dataBase.orm.one2one;

public class Transmission extends Entity{
    private String type;
    private int amountOfSpeeds;
    private String brand;
    public Transmission(int id, String type, int amountOfSpeeds, String brand){
        super(id);
        this.type = type;
        this.amountOfSpeeds = amountOfSpeeds;
        this.brand = brand;
    }
    public String getType(){
        return type;
    }
    public int getAmountOfSpeeds(){
        return amountOfSpeeds;
    }
    public String getBrand(){
        return brand;
    }
    @Override
    public String toString(){
        return super.toString() + ". Type : " + type + ". Amound of speed : " + amountOfSpeeds + ". Brand : " + brand;
    }
}
