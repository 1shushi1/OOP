package collections.hashMap;

public class Product {
    private String productName;
    private double price;
    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public String getProductName(){
        return productName;
    }
    public void info(){
        System.out.println("Product name : " + productName + ". Product price : " + price);
    }
}
