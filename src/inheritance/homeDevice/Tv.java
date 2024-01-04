package inheritance.homeDevice;

public class Tv extends Device{
    private int minVolume = 0;
    private int maxVolume = 100;
    private int volume;
    private int channels;
    private int currentChannel;
    public Tv(int volume, int channels){
        this.volume = volume;
        this.channels = channels;
    }
    @Override
    public void left(){
        changeChannelToTheLeft();
    }
    public void right(){
        changeChannelToTheRight();
    }
    public void up(){
        if (volume < maxVolume)
        volume++;
    }
    public void down(){
        if (volume > 0)
        volume--;
    }

    public void changeChannelToTheLeft(){
        if (isOn == true){
            currentChannel++;
            System.out.println("You've changed сhannel");
        }
    }
    public void changeChannelToTheRight(){
        if (isOn == true){
            currentChannel--;
            System.out.println("You've changed сhannel");
        }
    }
}
