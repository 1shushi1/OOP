package io.bytes.zip;

import java.io.Serializable;

public class Address implements Serializable {
    private String country;
    private String city;
    private String street;
    private int number;
    public Address(String country, String city, String street, int number){
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }
    public String getCountry(){
        return country;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public int getNumber(){
        return number;
    }
}
