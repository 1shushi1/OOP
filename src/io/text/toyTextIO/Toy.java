package io.text.toyTextIO;

import java.util.HashMap;
public class Toy {
    private String title;
    private double price;
    private String brand;
    private HashMap<String, Integer> fitcherMap;
    private int ageFrom;
    private String material;
    public Toy(String title, double price, String brand, HashMap<String, Integer> fitcherMap, int ageFrom, String material){
        this.title = title;
        this.price = price;
        this.brand = brand;
        this.fitcherMap = fitcherMap;
        this.ageFrom = ageFrom;
        this.material = material;
    }
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public String getBrand(){
        return brand;
    }
    public HashMap<String, Integer> getFitcherMap(){
        return fitcherMap;
    }
    public int getAgeFrom(){
        return ageFrom;
    }
    public String getMaterial(){
        return material;
    }
    @Override
    public String toString(){
        String empty = "";
        for (String details : fitcherMap.keySet()){
            empty += details + " - " + fitcherMap.get(details) + "\n";
        }
        return "Title : " + title + "\nPrice : " + price + "\nBrand : " + brand + "\nFitchers : " + "\n" + empty +
        "Age from : " + ageFrom + "\nMaterial : " + material;
    }
    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Toy)){
            return false;
        }
        Toy toy = (Toy) object;
        return toy.title.equals(title) && toy.price == price && toy.brand.equals(brand);
    }
}
