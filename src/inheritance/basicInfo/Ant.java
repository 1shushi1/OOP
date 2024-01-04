package inheritance.basicInfo;

public final class Ant extends Insect{
    private boolean hasPoison;
    public Ant(boolean hasPoison){
        super("Ant", "Insect", "Brown", 0.1, 1, 6, false );
        this.hasPoison = hasPoison;
    }
    public boolean isHasPoison(){
        return hasPoison;
    }
    @Override
    public void voice(){
        System.out.println("sShh");
    }
}
