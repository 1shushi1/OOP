package complexObjects.phone;

public class Sim {
    private String phoneNumber;
    private double tariff1;
    private double tariff2;
    private double tariff3;
    private double balance;
    private String operator;
    public Sim(String phoneNumber, double tariff1, double tariff2, double tariff3, double balance, String operator){
        this.phoneNumber = phoneNumber;
        this.tariff1 = tariff1;
        this.tariff2 = tariff2;
        this.tariff3 = tariff3;
        this.balance = balance;
        this.operator = operator;
    }
    public double tariffYouAreUsing(String calleePhoneNum){
        if (calleePhoneNum.startsWith("+38096") || calleePhoneNum.startsWith("+38068") && phoneNumber.startsWith("+38096") || phoneNumber.startsWith("+38068")){
            return tariff1;
        }
        if (calleePhoneNum.startsWith("+38066") || calleePhoneNum.startsWith("+38050") || calleePhoneNum.startsWith("+38099") && phoneNumber.startsWith("+38066") ||
        phoneNumber.startsWith("+38050") || phoneNumber.startsWith("+38099")){
            return tariff1;
        }
        if (calleePhoneNum.startsWith("+38096") || calleePhoneNum.startsWith("+38068") && phoneNumber.startsWith("+38066") ||
                phoneNumber.startsWith("+38050") || phoneNumber.startsWith("+38099")){
            return tariff2;
        }
        if (calleePhoneNum.startsWith("+38066") || calleePhoneNum.startsWith("+38050") || calleePhoneNum.startsWith("+38099") && phoneNumber.startsWith("+38096")
                || phoneNumber.startsWith("+38068")){
            return tariff2;
        }
        return tariff3;

    }
    public void topUp(double balance){
        this.balance += balance;
    }
    public void debitFundsFromBalance(double tariff){
        double tariffPricePerSecond = tariff/60;
        if (balance > tariffPricePerSecond){
            this.balance -= tariffPricePerSecond;
        }
    }
    public void tariffChanger(int tariffNumber, double tariff){
        if (tariffNumber == 1){
            tariff1 = tariff;
        }
        if (tariffNumber == 2){
            tariff2 = tariff;
        }
        if (tariffNumber == 3){
            tariff3 = tariff;
        }
    }
    public String getOperator(){
        return operator;
    }
    public double getBalance(){
        return balance;
    }
}
