package inheritance.homeDevice;

public class Conditioner extends Device {
    private double temperature;
    public static final double MAXTEMPERATURE = 35;
    public static final double MINTEMPERATURE = 15;
    private String mode = "Cold";
    public Conditioner(double temperature){
        this.temperature = temperature;
    }
    @Override
    public void left(){
        decreaseTemperature();
    }
    @Override
    public void right(){
        increaseTemperature();
    }
    @Override
    public void up(){
        if (mode.equals("Cold")){
            mode = "Warm";
        }
        System.out.println("You've changed mode to " + mode);
    }
    @Override
    public void down(){
        if (mode.equals("Warm")){
            mode = "Cold";
        }
        System.out.println("You've changed mode to " + mode);
    }
    public void increaseTemperature(){
        if (temperature < MAXTEMPERATURE) {
            temperature++;
        }
        System.out.println("Current temperature : " + temperature);
    }
    public void decreaseTemperature() {
        if (MINTEMPERATURE > temperature) {
            temperature--;
        }
        System.out.println("Current temperature : " + temperature);
    }
}
