package inheritance.homeDevice;

public class Heater extends Device{
    private double kW;
    private double maxKw = 50;
    public static final double MINKW = 0;
    public Heater(double kW){
        this.kW = kW;
    }
    @Override
    public void left(){
        decreaseKw();
    }
    public void right(){
        increaseKw();
    }
    @Override
    public void up(){
    }
    @Override
    public void down(){
    }
    public void increaseKw(){
        if (kW < maxKw){
            kW++;
            System.out.println("You've increase kW to " + kW);
        }
    }
    public void decreaseKw(){
        if (kW > MINKW){
            kW--;
            System.out.println("You've decreased kW to " + kW);
        }
    }
}
