package interfaces.computer;

public class InkJet implements Printable{
    @Override
    public void print(String message){
        System.out.println("InkJet is printing : " + message);
    }
}
