package inheritance.homeDevice;

public abstract class Device {
    protected boolean isOn;

    public void isOnOff(){
        if (isOn == false){
            isOn = true;
        } else {
            isOn = false;
        }
    }
    public abstract void left();
    public abstract void right();
    public abstract void up();
    public abstract void down();

}
