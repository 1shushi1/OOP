package patterns.strategy.payStrategy;

public class Product implements Cloneable{
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;

    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name : " + name + ". Price : " + price;
    }
    @Override
    public Product clone(){
        return new Product(name, price);
    }
}
