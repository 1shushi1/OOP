package statics.enums.car;

enum CarColor{BLACK, RED, BLUE, GREEN, YELLOW, WHITE, GREY, BROWN}
enum CarBrand{BWM, ROLLS_ROYCE, MINI}

public class Car {
    private CarColor carColor;
    private CarBrand carBrand;
    private Engine engine;
    private Transmission transmission;
    public Car(CarColor carColor, CarBrand carBrand, Engine engine, Transmission transmission){
        this.carColor = carColor;
        this.carBrand = carBrand;
        this.engine = engine;
        this.transmission = transmission;
    }
    public void info(){
        System.out.println("You car is a " + carBrand + ". Your car color - " + carColor);
        if (engine != null){
            engine.info();
        } else {
            System.out.println("There is no engine");
        }
        if (transmission != null){
            transmission.info();
        } else {
            System.out.println("There is no transmission");
        }
    }
    public void setEngine(Engine engine){
        this.engine = engine;
    }
    public void setTransmission(Transmission transmission){
        this.transmission = transmission;
    }
}
