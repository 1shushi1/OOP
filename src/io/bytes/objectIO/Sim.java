package io.bytes.objectIO;

import java.io.Serializable;

public class Sim implements Serializable {
    private String number;
    private String operator;
    private double tarif1;
    private double tarif2;
    private int balance;
    public Sim(String number, String operator, double tarif1, double tarif2, int balance){
        this.number = number;
        this.operator = operator;
        this.tarif1 = tarif1;
        this.tarif2 = tarif2;
        this.balance = balance;
    }
    public String getNumber(){
        return number;
    }
    public String getOperator(){
        return operator;
    }
    public double getTarif1(){
        return tarif1;
    }
    public double getTarif2(){
        return tarif2;
    }
    public int getBalance(){
        return balance;
    }
}
