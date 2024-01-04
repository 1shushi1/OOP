package io.bytes.data;

import java.util.Date;

public class Product {
    private String title;
    private String brand;
    private Date date;
    private double price;
    private boolean isAvailable;
    private byte [] photo;
    public Product(String title, String brand, Date date, double price, boolean isAvailable, byte [] photo){
        this.title = title;
        this.brand = brand;
        this.date = date;
        this.price = price;
        this.isAvailable = isAvailable;
        this.photo = photo;
    }
    public Product(String title, String brand, double price){
        this.title = title;
        this.brand = brand;
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public String getBrand(){
        return brand;
    }
    public Date getDate(){
        return date;
    }
    public double getPrice(){
        return price;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public byte [] getPhoto(){
        return photo;
    }
    @Override
    public String toString(){
        return "Title : " + title + "\nBrand : " + brand + "\nDate : " + date + "\nPrice : " + price + "\nAvailability : " +
        isAvailable + "\nPhoto : " + photo;
    }
    @Override
    public int hashCode(){
        int hashCode = 18;
        hashCode = 18 * hashCode + title.hashCode();
        hashCode = 18 * hashCode + brand.hashCode();
        hashCode = 18 * hashCode + Double.hashCode(price);
        return hashCode;
    }
    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Product)){
            return false;
        }
        Product product = (Product) object;
        if (title.equals(product.getTitle()) && brand.equals(product.getBrand()) && price == product.getPrice()){
            return true;
        }
        // ми повертаємо тру, якщо вираз знизу дасть тру( без іфа )
        return false;
    }
}
