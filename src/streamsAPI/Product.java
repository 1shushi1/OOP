package streamsAPI;

import java.util.Comparator;

public class Product {
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
    public int getAmount(){
        return amount;
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Product)){
            return false;
        }
        Product product = (Product) o;
        return product.name.equals(name) && product.price == price;
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode += 13 + name.hashCode();
        return hashCode += 13 + Double.hashCode(price);
    }
}
