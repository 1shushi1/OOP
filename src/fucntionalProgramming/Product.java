package fucntionalProgramming;

public class Product {
    private String title;
    private int amount;
    private double price;
    public Product(String title, int amount, double price){
        this.title = title;
        this.amount = amount;
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public int getAmount(){
        return amount;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Title : " + title + ". Amount : " + amount + ". Price : " + price + ". Total : " + amount * price;
    }
}
