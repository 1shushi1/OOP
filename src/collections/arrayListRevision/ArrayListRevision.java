package collections.arrayListRevision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListRevision {
    public static void main(String[] args) {
        //створити та заповнити лист стрінгами а потім знайти найкоротший стрінг в листі
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello world!");
        arrayList.add("Bye world!");
        arrayList.add("How are you doing?");
        int minPos = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() < arrayList.get(minPos).length()) {
                minPos = i;
            }
        }
        System.out.println(arrayList.get(minPos));
        //є лист з інтами. Знайти середнє парних додатніх
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Collections.addAll(integerArrayList, 12, -2, -3, 4, 5, -6, 7, 8, 9, -10, 11, -12, 13, 14, 15, -16, 17, 18, -19);
        double sum = 0;
        int counter = 0;
        for (int i = 0; i < integerArrayList.size(); i++) {
            if (integerArrayList.get(i) > 0 && integerArrayList.get(i) % 2 == 0) {
                sum += integerArrayList.get(i);
                counter++;
            }
        }
        sum /= counter;
        System.out.println(sum);
        //є лист стрінгів. розвернути його елементи задом наперед
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "vasya", "petya", "artem");
        System.out.println("Before " + stringArrayList);
        for (int i = 0, j = stringArrayList.size() - 1; i < stringArrayList.size() / 2; i++, j--) {
            String temp = stringArrayList.get(i);
            stringArrayList.set(i, stringArrayList.get(j));
            stringArrayList.set(j, temp);
        }
        System.out.println("After " + stringArrayList);
        //є лист інтів. Видалити з нього всі відємні елементи
        //йшли з кінця, бо після видалення комірка лишається пуста, і елемент з комірки попереду переміщяється на ту, де видалили елемент, тому краще йти з кінця
        //або повторно переглядати комірку
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 12, -2, -3, -4, -5, -6, 7, 8, 9, -10, 11, -12, 13, 14, 15, -16, 17, 18, -19);
        for (int i = numbers.size() - 1; i > 0; i--) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);
        //в листі інтів знайти номер позиції де ледить максимальний відємний елемент
        ArrayList<Integer> negativeNumber = new ArrayList<>();
        Collections.addAll(negativeNumber, 12, -2, -3, -4, -5, -6, 7, -80, 9, -10, 11, -12, 13, 14, 15, -16, 17, 18, -19);
        int mxNegative = 0;
        int index = 0;
        for (int i = 0; i < negativeNumber.size(); i++) {
            if (negativeNumber.get(i) < 0) {
                if (negativeNumber.get(i) < mxNegative) {
                    mxNegative = negativeNumber.get(i);
                    index = negativeNumber.indexOf(mxNegative);
                }
            }
        }
        System.out.println(index);
        //відсортувати лист інтів по спаданню
        ArrayList<Integer> sortingNumbers = new ArrayList<>();
        Collections.addAll(sortingNumbers, 12, -2, -3, -4, -5, -6, 7, -80, 9, -10, 11, -12, 13, 14, 15, -16, 17, 18, -19);
        Collections.sort(sortingNumbers);
        Collections.reverse(sortingNumbers);
        System.out.println(sortingNumbers);
        //є 2 листа інтів. Обєднати їх та видалити пусті  (з налом) елементи та відсортувати по зростанню
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.addAll(list1, 12, -2, -3, null, -5, -6, 7, -80, 9, null);
        Collections.addAll(list2, null, -12, 13, 14, null, -16, 17, 18, null);
        list1.addAll(list2);
        for (int i = list1.size() - 1; i > 0; i--) {
            if (list1.get(i) == null) {
                list1.remove(i);
            }
        }
        Collections.sort(list1);
        System.out.println(list1);
        ArrayList<String> text = new ArrayList<>();
        Collections.addAll(text, "I was created in 2022 by a group of young programmers", "Hello world!", "I'm a new computer generation", "I work for microsoft");
        int indexOfTheBiggestString = positionNumber(text);
        System.out.println(indexOfTheBiggestString);
        ArrayList<Integer> listOfNumbers = listFiller(7);
        System.out.println(listOfNumbers);
        //----------------------------------
        ArrayList<Double> numberToChange = new ArrayList<>();
        Collections.addAll(numberToChange, 12.0, -2.0, -3.0, -4.0, -5.0, -6.0, 7.0, -80.0, 9.0, -10.0, 11.0, -12.0, 13.0, 14.0, 15.0, -16.0, 17.0, 18.0, -19.0);
        System.out.println(numberToChange);
        numberChanger(numberToChange);
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "Vasya", "Sasha", "Artem", "Vasya", "Kolya", "Sasha", "Vasya", "Artem", "Sasha", "Sasha", "Vasya", "Kolya", "Artem", "Kolya", "Vasya", "Sasha");
        stringCounter(words);

        Person person1 = new Person("Aria", "Alvarez", 7);
        Person person2 = new Person("Bodhi", "Banerjee", 15);
        Person person3 = new Person("Carlos", "Chikere", 23);
        Person person4 = new Person("Delara", "Dubois", 31);
        Person person5 = new Person("Estelle", "Eriksson", 42);
        Person person6 = new Person("Faizan", "Fujiwara", 50);
        Person person7 = new Person("Giselle", "Grimaldi", 58);
        Person person8 = new Person("Hiroshi", "Hassan", 64);
        Person person9 = new Person("Indira", "Ivankov", 71);
        Person person10 = new Person("Jovian", "Jeong", 79);
        Person person11 = new Person("Kalani", "Kowalski", 86);
        Person person12 = new Person("Lysandra", "Lombardi", 92);
        Person person13 = new Person("Mateo", "Mwangi", 100);
        Person person14 = new Person("Nadia", "Nakamura", 25);
        Person person15 = new Person("Orion", "Olsen", 33);

        ArrayList<Person> personList = new ArrayList<>();
        Collections.addAll(personList, person1, person2, person3, person4, person5, person6, person7, person8, person9, person10, person11, person12, person13, person14, person15);
        ArrayList<Person> newPersonList = ageFinder(personList, 25, 35);
        for (Person person : newPersonList) {
            person.info();
        }
        ArrayList<Integer> listOfEvenNumbers = generateEvenNumbers(10);
        System.out.println(listOfEvenNumbers);
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        Collections.addAll(stringArrayList1, "Hello world!111", "My name3 is 0Oleksi1", "What 1is you4r name?");
        ArrayList<String> newStringList = listWithoutNumbers(stringArrayList1);
        System.out.println(newStringList);
    }

    //є лист стрінгів повернути номер позиції де лежить стрінг з найбільшою кільуістю цифр
    public static int positionNumber(ArrayList<String> text) {
        int index = 0;
        for (int i = 0; i < text.size(); i++) {
            if (text.get(index).length() < text.get(i).length()) {
                index = i;
            }
        }
        return index;
    }

    // ф-я приймає ціле число та повертає лист такої довжини, заповнений числами 1 та 3 що повторюються в шахматному порядку
    public static ArrayList<Integer> listFiller(int number) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (i % 2 == 0 || i == 0) listOfNumbers.add(1);
            else {
                listOfNumbers.add(3);
            }
        }
        return listOfNumbers;
    }

    //приймаємо лист цілих на додатні елементи збільшуємо в 2 рази а відємні зменшуємо в 3 рази
    public static void numberChanger(ArrayList<Double> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.set(i, numbers.get(i) / 3);
            } else {
                numbers.set(i, numbers.get(i) * 2);
            }
        }
        System.out.println(numbers);
    }

    //є лист стрингів. Порахувати кількість кожного з елементів
    public static void stringCounter(ArrayList<String> text) {
        ArrayList<Integer> stringLength = new ArrayList<>();
        ArrayList<String> duplicates = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            int index = duplicates.indexOf(text.get(i));
            if (index == -1) {
                duplicates.add(text.get(i));
                stringLength.add(1);
            } else {
                stringLength.set(index, stringLength.get(index) + 1);
            }
        }
        System.out.println(duplicates);
        System.out.println(stringLength);
    }

    //ф-я приймає лист обєктів людей. знайти всіх людей з віком від такого до такого та повернути.
    public static ArrayList<Person> ageFinder(ArrayList<Person> personList, int from, int to) {
        ArrayList<Person> newPersonList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() >= from && personList.get(i).getAge() <= to) {
                newPersonList.add(personList.get(i));
            }
        }
        return newPersonList;
    }

    //ф-я приймає інт та повертає лист інтів (тільки парних) згенерованих рандомно в діапазоні від -12 до 16 такого розміру як цей інт, що передається
    public static ArrayList<Integer> generateEvenNumbers(int number) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < number; i++) {
            int n = r.nextInt(16 - -12) + -12;
            if (n % 2 == 0 && n != 0) {
                listOfNumbers.add(n);
            } else {
                i--;
            }
        }
        return listOfNumbers;
    }

    //приймаємо лист типу стрінг та повертаємо lист зі стрінгами без цифр
    public static ArrayList<String> listWithoutNumbers(ArrayList<String> stringList) {
        ArrayList<String> newStringList = new ArrayList<>();
        String word = "";
        for (int i = 0; i < stringList.size(); i++) {
            char[] arr = stringList.get(i).toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (!(arr[j] >= '0' && arr[j] <= '9')) {
                    word += arr[j];
                }
            }
            newStringList.add(word);
            word = "";
        }
        return newStringList;
    }
}
