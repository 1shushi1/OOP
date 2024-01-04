package exception.car;

import java.util.Scanner;

public class Car {
    private long currentTime;
    private Accumulator accumulator = new Accumulator();
    private Engine engine = new Engine();
    private FuelTank fuelTank = new FuelTank();
    private Display display = new Display();
    private CandleBox candleBox = new CandleBox();
    private Scanner s = new Scanner(System.in);
    private long difference;
    public Car(){
        menu();
    }
    public void menu(){
        System.out.println("Select a number : 1 - start, 2 - stop, 3 - accelerate, 4 - exit");
        int sel = s.nextInt();
        switch (sel){
            case 1 -> start();
            case 2 -> stop();
            case 3 -> accelerate();
            case 4 -> System.exit(0);
        }
        menu();
    }
    public void start(){
        try {
            accumulator.giveElCurrent();
            currentTime = System.currentTimeMillis();
            long stopTimeSec = difference/1000;
            for (int i = 0; i < stopTimeSec; i+=10) {
                fuelTank.pump(engine.getFuelConsumptionCarStop());
            }
            candleBox.giveSpark();
            engine.start();
            for (int i = engine.getCurrentNumOfRev(); i > 1500; i -= 200) {
                display.showRevolutions(engine.getCurrentNumOfRev());
                engine.decreaseRev(200);
                display.showRevolutions(engine.getCurrentNumOfRev());
            }
        } catch (CarException e){
            display.showErrors(e.getMessage());
        }
    }
    public void stop(){
        engine.setOn(false);
        System.out.println("You've turned off your car");
    }
    public void accelerate(){
        try {
            if (engine.isOn()) {
                System.out.println("Enter to which level you would like to increase a revolutions\nMax level is 7500");
                int rev = s.nextInt();
                int consumption = 0;
                for (int i = engine.getCurrentNumOfRev(); i < rev ; i += 200) {
                    display.showRevolutions(engine.getCurrentNumOfRev());
                    engine.addRevolutions();
                    display.showRevolutions(engine.getCurrentNumOfRev());
                    consumption++;
                }
                fuelTank.pump(consumption);
                long currentTGas = System.currentTimeMillis();
                difference = currentTGas - currentTime;
                System.out.println();
                for (int i = engine.getCurrentNumOfRev(); i > 1500 ; i-=200) {
                    display.showRevolutions(engine.getCurrentNumOfRev());
                    engine.decreaseRev(200);
                    display.showRevolutions(engine.getCurrentNumOfRev());
                }
            }
        } catch (CarException e){
            display.showErrors(e.getMessage());
        }

    }
    class Display{
        public void showErrors(String errorMessage){
            System.out.println("DISPLAY SHOWS : " + errorMessage);
        }
        public void showRevolutions(int revolutions){
            System.out.println(revolutions);
        }
    }
}
