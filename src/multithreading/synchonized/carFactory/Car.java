package multithreading.synchonized.carFactory;

public class Car {
    private String brand;
    private int serialNumber;
    public Car(String brand, int serialNumber){
        this.brand = brand;
        this.serialNumber = serialNumber;
    }
    public String toString(){
        return "\nBrand : " + brand + "\nSerial number : " + serialNumber;
    }
    public String getBrand(){
        return brand;
    }
    public int getSerialNumber(){
        return serialNumber;
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
        return car.getSerialNumber() == serialNumber;
    }
}
