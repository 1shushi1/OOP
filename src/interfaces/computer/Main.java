package interfaces.computer;

public class Main {
    public static void main(String[] args) {
        Fax fax = new Fax();
        InkJet inkJet = new InkJet();
        LazerJet lazerJet = new LazerJet();
        Computer computer = new Computer();
        computer.addPrinter(fax);
        computer.addPrinter(lazerJet);
        computer.addPrinter(inkJet);
        computer.listOfPrinters();
        computer.selectPrinter();
        computer.printMessage("Hello world!");
    }
}
