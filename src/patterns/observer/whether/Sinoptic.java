package patterns.observer.whether;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Sinoptic implements Observer {
    private HashMap<String, HashMap<String, Double>> localIndicators = new HashMap<>();

    @Override
    public void update(Observable o) {
        localIndicators.clear();
        WhetherCenter whetherCenter = (WhetherCenter) o;
        System.out.println(this.getClass().getSimpleName() + " was updated");
        double[] indicators = new double[3];
        for (String city : whetherCenter.getLocalIndicators().keySet()) {
            HashMap<String, Double> mapWithIndicators = new HashMap<>();
            double[] arr = whetherCenter.getLocalIndicators().get(city);
            mapWithIndicators.put("Temperature", arr[0]);
            mapWithIndicators.put("Humidity", arr[1]);
            mapWithIndicators.put("Wind strength", arr[2]);
            localIndicators.put(city, mapWithIndicators);
        }
//        StringBuilder sb = new StringBuilder();
//        localIndicators.forEach((c, i) -> { sb.append("City : " + c);
//            i.forEach((s, d) -> sb.append(s + " - " + d));
//        });
//        System.out.println(sb);
    }

    public void particularCityIndicators(String cityName) {
        System.out.println(getClass().getSimpleName() + " is showing the weather");
        String indicators = "";
        if (localIndicators.containsKey(cityName)){
            HashMap<String, Double> map = localIndicators.get(cityName);
            for (String indicatorsName : map.keySet()){
                indicators += indicatorsName + " - " + map.get(indicatorsName) + "\n";
            }
            System.out.println("City : " + cityName + " - " + indicators);
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
