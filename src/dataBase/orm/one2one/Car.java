package dataBase.orm.one2one;

public class Car extends Entity{
    private String brand;
    private String model;
    private int year;
    private Engine engine;
    public Car(long id, String brand, String model, int year){
        super(id);
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public Car(long id, String brand, String model, int year, Engine engine){
        super(id);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public Object getId(){
        return super.getId();
    }
    public Engine getEngine(){
        return engine;
    }
}
