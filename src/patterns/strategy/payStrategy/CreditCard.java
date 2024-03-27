package patterns.strategy.payStrategy;

import java.util.Date;

public class CreditCard {
    private String cardNumber;
    private double balance;
    private String cvv;
    private Date expiryDate;
    public CreditCard(String cardNumber, String cvv, Date expiryDate){
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public double getBalance(){
        return balance;
    }
    public String getCvv(){
        return cvv;
    }
    public Date getExpiryDate(){
        return expiryDate;
    }
}
