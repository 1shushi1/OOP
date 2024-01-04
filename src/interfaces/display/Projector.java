package interfaces.display;

public class Projector implements Display {
    private String name;
    private String brand;
    private double resolution;

    public Projector(String name, String brand, double resolution) {
        this.name = name;
        this.brand = brand;
        this.resolution = resolution;
    }

    @Override
    public void display(String info) {
        System.out.println(info);
    }
}
