package dataBase.orm.one2one;

public class Car extends Entity{
    private String brand;
    private String model;
    private int year;
    private Engine engine;
    private Transmission transmission;
    public Car(int id, String brand, String model, int year, Engine engine, Transmission transmission){
        super(id);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.transmission = transmission;
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
    public Transmission getTransmission(){
        return transmission;
    }
    @Override
    public String toString(){
        return "Id " + getId() + ". Brand : " + brand + ". Model : " + model + ". Year : " + year + ". Engine : " + engine + ". Transmission : " + transmission;
    }
}
