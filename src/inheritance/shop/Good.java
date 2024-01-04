package inheritance.shop;

public class Good {
    private String name;
    private int price;
    private String type;
    private String brand;
    public Good(String name, int price, String type, String brand){
        this.name = name;
        this.price = price;
        this.type = type;
        this.brand = brand;
    }
    public String toStirng(){
        return "Name : " + getClass().getSimpleName() + ". ";
    }
}
