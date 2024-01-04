package statics.enums.car;

public enum Transmission { TR_BMW_3_0("Automat", 6, "BMW_SHIFTER"), TR_BMW_4_4("Manual", 7, "BMW_SHIFTER"),
    TR_ROLLS_ROYCE_6("Automat", 7, "ROLLS_ROYCE_SHIFTER"), TR_ROLLS_ROYCE_8("Automat", 7,"ROLLS_ROYCE_SHIFTER" ),
    TR_MINI_2("Manual", 6,"MINI_SHIFTER" ), TR_MINI_3("Automat", 6, "MINI_SHIFTER");
    private String type;
    private int numberOfGears;
    private String brand;
    Transmission(String type, int numberOfGears, String brand){
        this.type = type;
        this.numberOfGears = numberOfGears;
        this.brand = brand;
    }
    public void info(){
        System.out.println("Transmission type - " + type + ". Number of gears : " + numberOfGears + ". Shifter brand " + brand + ".");
    }
    public String getType(){
        return type;
    }
    public int getNumberOfGears(){
        return numberOfGears;
    }
    public String getBrand(){
        return brand;
    }
}
