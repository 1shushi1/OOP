package streamsAPI;

import java.util.Comparator;

public class Product  {
    private String name;
    private double price;
    private int amount;
    public Product(String name, double price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "Name : " + name + " | Price : " + price + " | Amount : " + amount + " | Total product price : " + getTotalPrice();
    }
    public double getTotalPrice(){
        return price * amount;
    }
    public double getPrice(){
        return price;
    }
}
