package inheritance.equalsHashCode.example;

public class Engine {
    private String brand;
    private double power;
    private double volume;
    public Engine(String brand, double power, double volume){
        this.brand = brand;
        this.power = power;
        this.volume = volume;
    }
    @Override
    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object == null){
            return false;
        }
        if (object instanceof Engine){
            return true;
        }
        Engine engine = (Engine) object;
        if (brand.equals(engine.brand) && power == engine.power && volume == engine.volume){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode = 13 * hashCode + brand.hashCode();
        hashCode = 13 * hashCode + Double.hashCode(power);
        hashCode = 13 * hashCode + Double.hashCode(volume);
        return hashCode;
    }
}
