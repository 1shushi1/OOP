package multithreading.synchonized.waifNotify.shop;

public class Product {
    private String brand;
    private String type;
    private double price;
    public Product(String brand, String type, double price){
        this.brand = brand;
        this.type = type;
        this.price = price;
    }
    @Override
    public String toString(){
        return "\nBrand : " + brand + "\nType : " + type + "\nPrice : " + price;
    }
    @Override
    public boolean equals(Object ob){
        if (ob == this){
            return true;
        }
        if (ob == null){
            return false;
        }
        if (!(ob instanceof Product)){
            return false;
        }
        Product product = (Product) ob;
        return product.brand.equals(brand) && product.type.equals(type) && product.price == price;
    }
    public String getBrand(){
        return brand;
    }
    public String getType(){
        return type;
    }
}
