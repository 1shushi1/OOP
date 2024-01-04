package statics.simple;
//enum EyeColour{BROWN, BLUE, GREEN, HAZEL, BLACK}
public class Human {
    private String name;
    private static int population;
    public static final String RACE1 = "Nigger";
    public static final String RACE2 = "Europian";
    public static final String RACE3 = "Mongolia";
    private String race;
    private EyeColor eyeColor;
    public Human(String name, String race, EyeColor eyeColour){
        this.eyeColor = eyeColour;
        this.race = race;
        this.name = name;
        population++;
    }
    public void info(){
        System.out.println("My name is " + name + ". My race is " + race + ". His eye colour is " + eyeColor);
    }
}
