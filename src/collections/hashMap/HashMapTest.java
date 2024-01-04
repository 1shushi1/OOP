package collections.hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");
        map.put(5, "Elderberry");
        map.put(6, "Fig");
        map.put(7, "Grape");
        map.put(8, "Honeydew");
        map.put(9, "Iced Tea");
        map.put(10, "Jackfruit");
        map.put(11, "Kiwi");
        map.put(12, "Lemon");
        map.put(13, "Mango");
        map.put(14, "Nectarine");
        map.put(15, "Orange");
        int num = theShortestString(map);
        System.out.println(num);

        HashMap<Long, Product> productMap = new HashMap<>();
        productMap.put(101L, new Product("Laptop", 1000.99));
        productMap.put(102L, new Product("Mobile", 500.49));
        productMap.put(103L, new Product("Tablet", 300.39));
        productMap.put(104L, new Product("Headphones", 50.19));
        productMap.put(105L, new Product("Monitor", 200.89));
        productMap.put(106L, new Product("Mouse", 15.79));
        productMap.put(107L, new Product("Keyboard", 25.89));
        productMap.put(108L, new Product("Charger", 10.99));
        productMap.put(109L, new Product("Camera", 350.59));
        productMap.put(110L, new Product("Speakers", 60.29));
        productMap.put(111L, new Product("USB Drive", 8.49));
        productMap.put(112L, new Product("Microphone", 40.39));
        productMap.put(113L, new Product("Smart Watch", 150.89));
        productMap.put(114L, new Product("Webcam", 70.49));
        productMap.put(115L, new Product("Printer", 120.99));
        Product product = expensiveProduct(productMap);
        product.info();

        HashMap<String, Long> map2 = new HashMap<>();
        map2.put("Laptop", 101L);
        map2.put("Mobile", 102L);
        map2.put("Tablet", 103L);
        map2.put("Headphones", 104L);
        map2.put("Monitor", 105L);
        map2.put("Mouse", 106L);
        map2.put("Keyboard", 107L);
        map2.put("Charger", 108L);
        map2.put("Camera", 109L);
        map2.put("Speakers", 110L);
        map2.put("USB Drive", 111L);
        map2.put("Microphone", 112L);
        map2.put("Smart Watch", 113L);
        map2.put("Webcam", 114L);
        map2.put("Printer", 115L);
        hashMapReplace(map2);

        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "LunarEclipsesAnewMoon", "HarmoniousPegasusFly", "VividSkylineHorizon", "GlisteningStarDust", "CrimsonVortexDreams",
                "AzureWhisperingWind", "TwilightsEphemeralGlow", "GoldenHorizonMirth", "GalacticRainbowDance", "SilentNebulaWhispers");
        stringLength(stringArrayList);

        ArrayList<String> map3 = new ArrayList<>();
        Collections.addAll(map3, "Vasya", "Sasha", "Artem", "Vasya", "Kolya", "Sasha", "Vasya", "Artem", "Sasha", "Sasha", "Vasya", "Kolya", "Artem", "Kolya", "Vasya", "Sasha");
        stringCounter(map3);
    }

    //ф-я приймаэ мапу типу інт - стрінг та повертає інт, що відповідає найкоротшому стрінгу
    public static int theShortestString(HashMap<Integer, String> map) {
        int index = 0;
        String etalonValue = "lkasdjflskjadlkgjlkasjdks";
        for (Integer number : map.keySet()) {
            String currentValue = map.get(number);
            if (etalonValue.length() > currentValue.length()) {
                etalonValue = currentValue;
                index = number;
            }
        }
        return index;
    }

    //ф-я приймає мапу типу лонг - продукт та повертає найдорожчий товар
    public static Product expensiveProduct(HashMap<Long, Product> map) {
        Product productWithTheHighestPrice = new Product("", -1);
        for (Long number : map.keySet()) {
            Product product = map.get(number);
            if (product.getPrice() > productWithTheHighestPrice.getPrice()) {
                productWithTheHighestPrice = product;
            }
        }
        return productWithTheHighestPrice;
    }

    //є хешмапа типу стрінг - лонг. Зробити нову типу логш-стрінг та перекласти все навпаки
    public static void hashMapReplace(HashMap<String, Long> map) {
        HashMap<Long, String> newMap = new HashMap<>();
        for (String text : map.keySet()) {
            Long number = map.get(text);
            newMap.put(number, text);
        }
        for (Long number : newMap.keySet()) {
            System.out.println(number + " - " + newMap.get(number));
        }
    }

    //є лист зі стрінгами. Використовуючи мапу заповнити її як стріег-довжина стрінга
    public static void stringLength(ArrayList<String> stringList) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            int length = stringList.get(i).length();
            map.put(stringList.get(i), length);
        }
        for (String text : map.keySet()) {
            System.out.println(text + " - " + map.get(text));
        }
    }

    //в листі стрінгів порахувати кількість кожного зі стрінгів
    public static void stringCounter(ArrayList<String> arrayList) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (!(map.containsKey(arrayList.get(i)))) {
                map.put(arrayList.get(i), 1);
            } else {
                map.replace(arrayList.get(i), map.get(arrayList.get(i)) + 1);
            }
        }
        for (String text : map.keySet()){
            System.out.println(text + " - " + map.get(text));
        }
    }
}
