package io.bytes.zip;

import java.io.Serializable;
import java.util.Date;
public class Person implements Serializable {
    private String name;
    private String lastName;
    private Date date;
    private Address address;
    private int id;
    private double weight;
    public Person(String name, String lastName, Date date, Address address, int id, double weight){
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.address = address;
        this.id = id;
        this.weight = weight;
    }
    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Person)){
            return false;
        }
        Person person = (Person) object;
        return person.id == id;
    }
    @Override
    public String toString(){
        return "Name : " + name + "\nLast name : " + lastName + "\nDate : " + date + "\nAddress : " +
                "Country : " + address.getCountry() + ". City : " + address.getCity() + ". Street : " + address.getStreet() +
                ". Street number : " + address.getNumber() + "\n ID : " + id + "\nWeight : " + weight;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public Date getDate(){
        return date;
    }
    public int getId(){
        return id;
    }
    public Address getAddress(){
        return address;
    }
}
