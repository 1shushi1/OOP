package interfaces.computer;

public class LazerJet implements Printable{

    @Override
    public void print(String message){
        System.out.println("LazerJet is printing : " + message);
    }
}
