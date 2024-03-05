package patterns.observer.whether;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Gismeteo implements Observer{
    private HashMap<String, List<Double>> localIndicators = new HashMap<>();
    @Override
    public void update(Observable o){
        localIndicators.clear();
        WhetherCenter whetherCenter = (WhetherCenter) o;
        System.out.println(this.getClass().getSimpleName() + " was updated");
        for (String city : whetherCenter.getLocalIndicators().keySet()) {
            List<Double> indicators = new ArrayList<>();
            Collections.addAll(indicators, whetherCenter.getLocalIndicators().get(city)[0],whetherCenter.getLocalIndicators().get(city)[1], whetherCenter.getLocalIndicators().get(city)[2]);
            localIndicators.put(city, indicators);
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        localIndicators.forEach((c, i) -> stringBuilder.append("City : " + c + " - Temperature : " + i.get(0) + "\n"
//                + "Humidity : " + i.get(1) + "\n"
//                + "Wind strength : " + i.get(2) + "\n"));
//        System.out.println(stringBuilder);
    }
    public void partCityIndicators(String city){
        System.out.println(this.getClass().getSimpleName() + " is showing the weather");
        System.out.println("City - " + city + " :\n" + "Temperature : " + localIndicators.get(city).get(0) + "\n"
                + "Humidity : " + localIndicators.get(city).get(1) + "\n"
                + "Wind Strength : " + localIndicators.get(city).get(2));
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (o.getClass() != getClass()){
            return false;
        }
        return this.getClass().getSimpleName().equals(o.getClass().getSimpleName());
    }
}
