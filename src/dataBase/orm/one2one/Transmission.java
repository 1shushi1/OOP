package dataBase.orm.one2one;

public class Transmission extends Entity{
    private String type;
    private int amountOfSpeeds;
    private String brand;
    public Transmission(long id, String type, int amountOfSpeeds, String brand){
        super(id);
        this.type = type;
        this.amountOfSpeeds = amountOfSpeeds;
        this.brand = brand;
    }
}
