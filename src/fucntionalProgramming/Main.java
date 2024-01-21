package fucntionalProgramming;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //з використанням інтерфейсу лонгтудадлфанкшн отримати середшє значення цифп лонга
        LongToDoubleFunction function = (val) -> {
            String s1 = "" + val;
            int sumOfNum = 0;
            char[] arr = s1.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                sumOfNum += arr[i] - 48;
            }
            double avg = 1.0 * sumOfNum / s1.length();
            return avg;
        };
        double avg = function.applyAsDouble(1290837);
        System.out.println(Math.round(avg * 100) / 100.0);
        //використовуючи саплаєра згенерувати випадковий пароль що складається з 4 цифр та 5 букв - маленьких та великих
        Supplier<String> passwordGenerator = () -> {
            Random r = new Random();
            String empty = "";
            empty += r.nextInt(10000 - 1000) + 1000;
            for (int i = 0; i < 5; i++) {
                char letter = (char) (r.nextInt('z' - 'A') + 'A');
                if (!(letter >= 91 && letter <= 96)) {
                    empty += letter;
                } else {
                    i--;
                }
            }
            char[] password = empty.toCharArray();
            for (int i = 0; i < password.length; i++) {
                int indexOfNumberToChange = r.nextInt(password.length);
                char temp = password[i];
                password[i] = password[indexOfNumberToChange];
                password[indexOfNumberToChange] = temp;
            }
            return new String(password);
        };
        String password = passwordGenerator.get();
        System.out.println(password);
        //використовуючи консюмера, в листі товарів зробити дискаунт на товари на 13% якщо загальна вартість товара перевищує задану
        ArrayList<Product> products = new ArrayList<>();
        Product banana = new Product("Banana", 1000, 7.99);
        Product apple = new Product("Apple", 1500, 10);
        Product kiwi = new Product("Kiwi", 500, 14.55);
        Product strawberry = new Product("Strawberry", 2000, 21.99);
        Collections.addAll(products, banana, apple, kiwi, strawberry);
        double price = 12000;
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("----------------------");
        Consumer<ArrayList<Product>> discounts = (t) -> {
            for (Product product : t) {
                if (product.getPrice() * product.getAmount() > price) {
                    product.setPrice(product.getPrice() * 0.87);
                }
            }
        };
//        discounts.accept(products);
//        for (Product product : products){
//            System.out.println(product);
//        }
        Consumer<Product> discountPriceProd = (product) -> {
            if (product.getPrice() * product.getAmount() > price) {
                product.setPrice(product.getPrice() * 0.87);
            }
        };
        for (Product product : products) {
            discountPriceProd.accept(product);
        }
        for (Product product : products) {
            System.out.println(product);
        }
        //є лист стрінгів. Друканути його методом форіч
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String generatedString = "Element" + (i + 1);
            words.add(generatedString);
        }
        Consumer<String> print = (word) -> System.out.println(word);
        words.forEach(e -> System.out.println(e));
        //є мапа пипу інт - стрінг. Друканути її форічем
        HashMap<Integer, String> map = new HashMap<>();
        map.put(19, "Tolya");
        map.put(23, "Danya");
        map.put(44, "Grisha");
        map.put(15, "Artem");
        map.put(31, "Masha");
        map.forEach((e, t) -> System.out.println("Age : " + e + " - " + t));
        //фикористовуючи інтерфейс фанкшн перетворити лист стрінгів на лист інтів, в якому будуть довжини цих стрінгів
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "Tolya", "Vasya", "Sasha", "Tima", "Vika", "Valik", "Gregoryan");
        Function<ArrayList<String>, ArrayList<Integer>> converter = (t) -> {
            ArrayList<Integer> stringLength = new ArrayList<>();
            for (int i = 0; i < t.size(); i++) {
                stringLength.add(t.get(i).length());
            }
            return stringLength;
        };
        ArrayList<Integer> stringLength = converter.apply(names);
        for (Integer length : stringLength) {
            System.out.print(length + " ");
        }
        System.out.println();
        //використовуючи предікейт видалити з листа інтів всі відємні елементи та 0
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 0, -1, 5, -3, 2, -7, 4, -2, 8, -6, 3, -9, 10, -4);
        Predicate<Integer> listCleaner = (t) -> {
            if (t > 0 && t != 0) {
                return true;
            }
            return false;
        };

        for (int i = integers.size() - 1; i > 0; i--) {
            if (listCleaner.test(integers.get(i)) != true) {
                integers.remove(i);
            }
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
        //є лист стрінгів, видалити стрінги з довжиною, меншою за стільки-то
        int length = 10;
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Short");
        strings.add("A bit longer");
        strings.add("This one is really long");
        strings.add("Medium");
        strings.add("Tiny");
        strings.add("Quite long");
        strings.add("Shorter");
        strings.add("Super long string that goes on and on");
//        Predicate<String> remover = (t) -> {
//            if (t.length() < length){
//                return true;
//            }
//            return false;
//        };
//        for (int i = strings.size() - 1; i >= 0; i--) {
//            boolean ans = remover.test(strings.get(i));
//            if (ans){
//                strings.remove(i);
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }
        System.out.println();
        strings.removeIf((e) -> e.length() < length);
        strings.forEach((e) -> System.out.println(e));
        //є лист інтів. Зробити інверсію листа (всі відємні стають додатніми та навпаки
        ArrayList<Integer> integersToInvert = new ArrayList<>();
        Collections.addAll(integersToInvert, 1, 0, -1, 5, -3, 2, -7, 4, -2, 8, -6, 3, -9, 10, -4);
        for (int i = 0; i < integersToInvert.size(); i++) {
            integersToInvert.set(i, integersToInvert.get(i) * (-1));


            integersToInvert.forEach((e) -> System.out.print(e + " "));
            //є лист стрінгів, замвінити всі стрінги що короче такого-то та якесь слово
            String word = "SuperUltraPro";
            ArrayList<String> texts = new ArrayList<>();
            texts.add("Short");
            texts.add("A bit longer");
            texts.add("This one is really long");
            texts.add("Medium");
            texts.add("Tiny");
            texts.add("Quite long");
            texts.add("Shorter");
            texts.add("Super long string that goes on and on");
            UnaryOperator<String> changer = (t) -> {
                if (t.length() < word.length())
                    t = word;
                return t;
            };
            texts.replaceAll(changer);
            texts.forEach((e) -> System.out.println(e));
            //є лист інтів. Зробити інверсію листа (всі відємні стають додатніми та навпаки
            ArrayList<Integer> integersReplaceAll = new ArrayList<>();
            Collections.addAll(integersReplaceAll, 1, 0, -1, 5, -3, 2, -7, 4, -2, 8, -6, 3, -9, 10, -4);
            UnaryOperator<Integer> inverter = (t) -> -t;
            integersReplaceAll.replaceAll(inverter);
            integersReplaceAll.forEach(e -> System.out.print(e + " "));
            //з використанням інтерфейсу бінарі оператор підрахувати суму елементів в листі інтів
            ArrayList<Integer> intForSum = new ArrayList<>();
            Collections.addAll(intForSum, 1, 0, -1, 5, -3, 2, -7, 4, -2, 8, -6, 3, -9, 10, -4);
            BinaryOperator<Integer> calculation = (val1, val2) -> val1 + val2;
            int sum = 0;
            for (int j = 0; j < intForSum.size(); j++) {
                sum = calculation.apply(sum, intForSum.get(j));
            }
            System.out.println();
            System.out.println(sum);
            //відсотрувати лист даблів по зростанню сум їх цифр
            ArrayList<Double> doubles = new ArrayList<>();
            Collections.addAll(doubles, -2.3, 7.8, 0.1, -4.5, 9.2, 1.7, 3.6, -6.4);
            Comparator<Double> sortingDoubles = (t, r) -> -Double.compare(t, r);
            doubles.sort(sortingDoubles);
            System.out.println(doubles);
        }
    }
}
