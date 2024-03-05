package patterns.observer.whether;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WhetherCenter whetherCenter = new WhetherCenter();


        Sinoptic sinoptic = new Sinoptic();
        Gismeteo gismeteo = new Gismeteo();
        MeteoProg meteoProg = new MeteoProg();

        whetherCenter.addObserver(sinoptic);
        whetherCenter.addObserver(gismeteo);
        whetherCenter.addObserver(meteoProg);

        sinoptic.particularCityIndicators("Warsaw");

        whetherCenter.removeObserver(sinoptic);
        whetherCenter.updateInfo("Warsaw", new double[]{12, 65, 4});

        sinoptic.particularCityIndicators("Warsaw");


    }
}
