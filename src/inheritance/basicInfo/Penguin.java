package inheritance.basicInfo;

public class Penguin extends Bird{
    private double maxSwimmingLevel;
    private double minTemperatureInWhichTheyCanExist;
    public Penguin(double maxSwimmingLevel, double minTemperatureInWhichTheyCanExist){
        super("Penguin", "Bird", "White with black", 25, 100, 0, false);
        this.maxSwimmingLevel = maxSwimmingLevel;
        this.minTemperatureInWhichTheyCanExist = minTemperatureInWhichTheyCanExist;
    }
    public double getMaxSwimmingLevel(){
        return maxSwimmingLevel;
    }
    public double getMinTemperatureInWhichTheyCanExist(){
        return minTemperatureInWhichTheyCanExist;
    }
    @Override
    public void voice(){
    }
//    @Override
//    public void toEat(String food){
//        System.out.println(getClass().getSimpleName() + food);
//    }
}
