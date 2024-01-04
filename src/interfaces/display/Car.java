package interfaces.display;

public class Car implements Usb{
    private String brand;
    private String model;
    private int distance;
    private double fuelConsumption;
    public Car(String brand, String model, int distance, double fuelConsumption){
        this.brand = brand;
        this.model = model;
        this.distance = distance;
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String getData(){
        String info = "Brand : " + brand + "\n. Model : " + model + "\n. Distance : " + distance + "\n. Fuel consumption : " +
                fuelConsumption;
        return info;
    }
}
