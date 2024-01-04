package statics.singleTone;

public class Sun {
    private String color = "Yellow";
    private int size = 864000;
    private static Sun sun = new Sun();
    private Sun(){

    }
    public void theSunIsShinning(){
        System.out.println("The sun is shining");
    }
    public static Sun getSun(){
        return sun;
    }
}
