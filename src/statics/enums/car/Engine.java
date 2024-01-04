package statics.enums.car;

public enum Engine { BMW_D_35(3.0, 420,"Disel" ), BMW_G_5M(4.4, 560, "Gazolin"),
    BMW_D_2(2.0, 245, "Disel"), ROLLS_ROYCE_G_6(6.0, 430, "Gazolina"),
    ROLLS_ROYCE_G_8(8.0, 500, "Gazoline"),
    MINI_D_2(2.0, 245, "Disel"), MINI_D_3(3.0, 300, "Disel");
    private double volume;
    private int power;
    private String type;
    Engine(double volume, int power, String type){
        this.volume = volume;
        this.power = power;
        this.type = type;
    }
    public void info(){
        System.out.println("Engine volume is " + volume + ". Engine power is " + power + ". Engine type is " + type);
    }
    public double getVolume(){
        return volume;
    }
    public int getPower(){
        return power;
    }
    public String getType(){
        return type;
    }
}
