package inheritance.basicInfo;

public class ClownFish extends Fish{
    private boolean isMale;
    public ClownFish(boolean isMale){
        super(false,"Clown-Fish", "Fish","Orange", 0.2, 9);
        this.isMale = isMale;
    }
    public boolean isMale(){
        return isMale;
    }
}
