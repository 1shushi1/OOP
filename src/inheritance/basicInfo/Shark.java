package inheritance.basicInfo;

public class Shark extends Fish{
    private int amountOfTeeth;
    public Shark(int amountOfTeeth){
        super(true, "Shark", "Fish", "Grey", 900, 4);
        this.amountOfTeeth = amountOfTeeth;
    }
    public int getAmountOfTeeth(){
        return amountOfTeeth;
    }
}
