package inheritance.equalsHashCode.example;

public class GearBox {
    private String type;
    private int numberOfGears;
    private String brand;
    public GearBox(String type, int numberOfGears, String brand){
        this.type = type;
        this.numberOfGears = numberOfGears;
        this.brand = brand;
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
        GearBox gearBox = (GearBox) object;
        if (type.equals(gearBox.type) && numberOfGears == gearBox.numberOfGears && brand.equals(gearBox.brand)){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode = 13 * hashCode + type.hashCode();
        hashCode = 13 * hashCode + Integer.hashCode(numberOfGears);
        hashCode = 13 * hashCode + brand.hashCode();
        return hashCode;
    }
}
