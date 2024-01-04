package inheritance.basicInfo;

public class Dove extends Bird {
    private boolean isDomestic;
    public Dove(boolean isDomestic){
        super("Dove", "Bird", "White", 120, 12, 6, true);
        this.isDomestic = isDomestic;
    }
    public boolean isDomestic(){
        return isDomestic;
    }
    public void voice(){
        System.out.println("Kurluk-kurluk");
    }
}
