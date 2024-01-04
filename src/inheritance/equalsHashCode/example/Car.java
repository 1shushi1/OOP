package inheritance.equalsHashCode.example;

public class Car {
    private long vinCode;
    private String brand;
    private String model;
    private double price;
    private Engine engine;
    private GearBox gearBox;

    public Car(long vinCode, String brand, String model, double price, Engine engine, GearBox gearBox) {
        this.vinCode = vinCode;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.engine = engine;
        this.gearBox = gearBox;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        // instaceof - перевіряє чи змінна має такий тип
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        if (vinCode == car.vinCode && brand.equals(car.brand) && model.equals(car.model)
                && price == car.price && engine.equals(car.engine) && gearBox.equals(car.gearBox)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 13;
        hashCode = 13 * hashCode + brand.hashCode();
        hashCode = 13 * hashCode + Long.hashCode(vinCode);
        hashCode = 13 * hashCode + model.hashCode();
        hashCode = 13 * hashCode + Double.hashCode(price);
        hashCode = 13 * hashCode + engine.hashCode();
        hashCode = 13 * hashCode + gearBox.hashCode();
        return hashCode;
    }
}
