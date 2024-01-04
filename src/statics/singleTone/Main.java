package statics.singleTone;

public class Main {
    public static void main(String[] args) {
        Sun sun1 = Sun.getSun();
        Sun sun2 = Sun.getSun();
        System.out.println(sun1 + " " + sun2);
        Moon moon = Moon.MOON;
        System.out.println(moon.getColor());
        System.out.println(moon.getSize());
        moon.shiningInTheDark();
    }
}
