package inheritance.basicInfo;

public class Grasshopper extends Insect{
    private double jumpingLength;
    public Grasshopper(double jumpingLength){
        super("Grasshopper", "Insect", "Green", 0.3, 5,6, false);
        this.jumpingLength = jumpingLength;
    }
    public double getJumpingLength(){
        return jumpingLength;
    }
    @Override
    public String toString(){
        return super.toString() + ". His jumping length is : " + jumpingLength;
    }
    public void voice(){
    }

}
