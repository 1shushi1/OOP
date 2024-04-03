package patterns.momento;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String brand;
    private double price;
    private int amount;
    private int rating;
    private Date date;

    public Product(int id, String name, String brand, double price, int amount, int rating, Date date) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
        this.rating = rating;
        this.date = date;
    }

    public void setMomento(Object snapshot) {
        Momento momento = (Momento) snapshot;
        this.id = momento.id;
        this.name = momento.name;
        this.brand = momento.brand;
        this.price = momento.price;
        this.amount = momento.amount;
        this.rating = momento.rating;
        this.date = momento.date;
    }

    public Object getMomento() {
        return new Momento(this.id, this.name, this.brand, this.price, this.amount, this.rating, this.date);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setRating(int rating) {
        this.name = name;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID : " + id + ". Name : " + name + ". Brand : " + brand + ". Price : " + price + ". Amount : " + amount + ". Rating : " + rating + ". Date : " + date;
    }

    private class Momento {
        private int id;
        private String name;
        private String brand;
        private double price;
        private int amount;
        private int rating;
        private Date date;

        public Momento(int id, String name, String brand, double price, int amount, int rating, Date date) {
            this.id = id;
            this.name = name;
            this.brand = brand;
            this.price = price;
            this.amount = amount;
            this.rating = rating;
            this.date = date;
        }
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
        return product.id == id;
    }
    @Override
    public int hashCode(){
        int hashCode = 3;
        return hashCode * 3 + id;
    }
}
