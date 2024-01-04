package interfaces.display;

public class Monitor implements Display {
    private String name;
    private String brand;
    private double hZ;

    public Monitor(String name, String brand, double hz) {
        this.name = name;
        this.brand = brand;
        this.hZ = hZ;
    }

    @Override
    public void display(String info) {
        System.out.println(info);
    }
}
