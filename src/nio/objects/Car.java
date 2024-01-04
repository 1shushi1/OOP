package nio.objects;

import java.io.Serializable;

public class Car implements Serializable {
    private Engine engine;
    private String brand;
    private String model;
    private int year;
    private long vinCode;
    public Car(Engine engine, String brand, String model, int year, long vinCode){
        this.engine = engine;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vinCode = vinCode;
    }
    @Override
    public String toString(){
        return "Car brand : " + brand + "\nModel : " + model + "\nYear : " + year +
                "\nVin code : " + vinCode + "\n Engine : " + "\nFuel consumption : " + engine.getFuelConsumption() +
                "\nHorse powers : " + engine.getHorsePowers() + "\nVolume : " + engine.getVolume();

    }
    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Car)){
            return false;
        }
        Car car = (Car) object;
        return car.vinCode == vinCode;
    }
}
