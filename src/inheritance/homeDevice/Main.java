package inheritance.homeDevice;

public class Main {
    public static void main(String[] args) {
        Remote remote = new Remote();
        remote.onOff();
        remote.left();
        remote.left();
        remote.right();
        remote.up();
        remote.down();
        remote.selectDevice("Conditioner");
        remote.onOff();
        remote.left();
        remote.right();
        remote.up();
        remote.down();
        remote.selectDevice("Tv");
        remote.onOff();
        remote.left();
        remote.right();
        remote.up();
        remote.down();
    }
}
