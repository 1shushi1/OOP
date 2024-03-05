package patterns.observer.whether;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class WhetherCenter implements Observable {
    private HashMap<String, double[]> localIndicators = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    public WhetherCenter() {
        localIndicators.put("Warsaw", new double[]{16, 65, 2});
        localIndicators.put("Berlin", new double[]{8, 80, 3});
        localIndicators.put("Kyiv", new double[]{8, 57, 4});
        localIndicators.put("New-York", new double[]{7, 86, 2});
        localIndicators.put("Barcelona", new double[]{17, 44, 2});
    }
    public void updateInfo(String cityName, double [] indicators) {
//        localIndicators.replace(cityName, indicators);
//        observers.forEach(e -> e.update(this));
        for (String city : localIndicators.keySet()){
            if (city.equals(cityName)){
                localIndicators.replace(city, indicators);
                notifyObservers();
            } else {
                localIndicators.put(cityName, indicators);
                notifyObservers();
            }
        }
    }
    public void removeLocation(String cityName){
        localIndicators.remove(cityName);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
        o.update(this);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(e -> e.update(this));
    }
    public HashMap<String, double []> getLocalIndicators(){
        return localIndicators;
    }
}
