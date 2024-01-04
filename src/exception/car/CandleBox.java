package exception.car;

import java.util.ArrayList;

public class CandleBox {
    private int amountOfCandles = 12;
    private ArrayList<Candle> candles = new ArrayList<>();

    public CandleBox() {
        for (int i = 0; i < amountOfCandles; i++) {
            candles.add(new Candle());
        }
    }

    public void giveSpark() throws CarException{
        int counter = 0;
        for (int i = 0; i < candles.size(); i++) {
            try{
                candles.get(i).giveSpark();
            } catch (CarException e){
                counter++;
            }
        }
        if (counter >= amountOfCandles/2){
            throw new CarException("More than 50% of candles doesn't work");
        }
    }
}
