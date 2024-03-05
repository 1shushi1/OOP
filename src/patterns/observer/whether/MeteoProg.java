package patterns.observer.whether;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MeteoProg implements Observer{
    private HashMap<String, String> localIndicators = new HashMap<>();
    @Override
    public void update(Observable o){
        localIndicators.clear();
        WhetherCenter whetherCenter = (WhetherCenter) o;
        System.out.println(this.getClass().getSimpleName() + " was updated");
        for (String city : whetherCenter.getLocalIndicators().keySet()) {
            String indicators = "";
            for (int i = 0; i < whetherCenter.getLocalIndicators().get(city).length; i++) {
                indicators += whetherCenter.getLocalIndicators().get(city)[i] + " ";
            }
            localIndicators.put(city, indicators);
        }
    }
    public void cityWeatherInfo(String cityName){
        System.out.println(this.getClass().getSimpleName() + " is showing the weather");
        if (localIndicators.containsKey(cityName)){
            List<Double> indicators = Arrays.stream(localIndicators.get(cityName).split(" ")).map((e -> Double.parseDouble(e))).toList();
            System.out.println("City - " + cityName + " : " + "\nTemperature : " + indicators.get(0) + "\n"
                                                            + "Humidity : " + indicators.get(1) + "\n"
                                                            + "Wind strength : " + indicators.get(2));
        }
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
