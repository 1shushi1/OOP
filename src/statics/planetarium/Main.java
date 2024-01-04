package statics.planetarium;

public class Main {
    public static void main(String[] args) {
        Planetarium planetarium = new Planetarium("Washington Planetarium", "Washington, D.C, USA", 34.5 );
        Planetarium planetarium1 = new Planetarium("Texas Planetarium", "Texas, USA", 52.99);
        Planetarium planetarium2 = new Planetarium("Kacevelli", "Crimea, Ukraine", 15.99);
        planetarium.print();
        planetarium1.print();
        planetarium2.print();
    }
}
