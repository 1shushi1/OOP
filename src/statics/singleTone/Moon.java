package statics.singleTone;

public enum Moon { MOON(123000, "white");
    public int size;
    public String color;
    Moon(int size, String color){
        this.size = size;
        this.color = color;
    }
    public int getSize(){
        return size;
    }
    public String getColor(){
        return color;
    }
    public void shiningInTheDark(){
        System.out.println("Moon shining in the dark");
    }
}
