package complexObjects.phone;

public class Battery {
    private double maxPercentage = 100;
    private double currentPercentage;

    public Battery(double currentPercentage){
        this.currentPercentage = maxPercentage;
    }
    public double getCurrentPercentage(){
        return currentPercentage;
    }
    public void setCurrentPercentage(double currentPercentage){
        this.currentPercentage = currentPercentage;
    }
    public void chargeBattery(double chargePercentage){
        if (chargePercentage <= maxPercentage){
            currentPercentage += chargePercentage;
        }
    }
    public void dischargeBattery(double dischargePercentage){
        if (currentPercentage >= dischargePercentage){
            currentPercentage -= dischargePercentage;
        }
    }
}
