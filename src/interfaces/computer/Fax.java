package interfaces.computer;

public class Fax implements Printable{
    @Override
    public void print(String message){
        System.out.println("Fax is printing " + message);
    }
}
