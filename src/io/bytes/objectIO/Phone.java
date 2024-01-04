package io.bytes.objectIO;

import java.io.Serializable;
import java.util.ArrayList;
public class Phone implements Serializable {
    private String brand;
    private ArrayList<Sim> simCards;
    private String model;
    private byte [] photo;
    private double price;
    private long serialNumber;
    public Phone(String brand, ArrayList<Sim> simCards, String model, byte [] photo, double price, long serialNumber){
        this.brand = brand;
        this.simCards = simCards;
        this.model = model;
        this.photo = photo;
        this.price = price;
        this.serialNumber = serialNumber;
    }
    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Phone)){
            return false;
        }
        Phone phone = (Phone) object;
        return serialNumber == phone.serialNumber;
    }
    public double getPrice(){
        return price;
    }
    public String getModel(){
        return model;
    }
    public String getBrand(){
        return brand;
    }
    public String toString(){
        for (Sim sim : simCards) {
            return "\nBrand : " + brand + "\nSim Cards info : " + "Phone number : " + sim.getNumber() + ". Operator : " + sim.getOperator() +
                    ". Balance : " + sim.getBalance() + "\nModel : " + model + "\nPrice : " + price;
        }
        return null;
    }
}
