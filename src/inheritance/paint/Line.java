package inheritance.paint;

public enum Line {
    SMALL(1), MEDIUM(2), LARGE(5);
    private int size;
    Line(int size){
        this.size = size;
    }
    @Override
    public String toString(){
        return super.toString() + " " + size;
    }
}
