package io.bytes.zip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Vanya", "Bochkin", new Date(2014-1900, 6, 23), new Address("Ukraine", "Kyiv",
                "Hordienka", 10), 1, 75);
        Person person2 = new Person("Tolya", "Lysychkin", new Date(2010-1900, 3, 14), new Address("Ukraine", "Lviv",
                "Chernyahovskogo", 7), 2, 98);
        Person person3 = new Person("Misha", "Kit", new Date(2005-1900, 9, 21), new Address("Ukraine", "Lviv",
                "Petrenka", 1), 3, 65);

//        boolean ans = PersonController.save(person1);
//        boolean ans1 = PersonController.save(person2);
//        boolean ans2 = PersonController.save(person3);
//
//        System.out.println(ans);
//        System.out.println(ans1);
//        System.out.println(ans2);

//        ArrayList<Person> persons = new ArrayList<>();
//        Collections.addAll(persons, person1, person2, person3);
//        boolean ans = PersonController.saveAll(persons);
//        System.out.println(ans);
//
//        ArrayList<Person> foundPersons = PersonController.findAll();
//        System.out.println(foundPersons);

//        boolean ans = PersonController.delete(person1);
//        System.out.println(ans);

//        boolean ans = PersonController.update(person3, person1);
//        System.out.println(ans);
//
//        ArrayList<Person> foundPersons = PersonController.findAll();
//        System.out.println(foundPersons);
//
//        ArrayList<Person> foundPerson = PersonController.find("Tolya", "Lysychkin", new Date(2010-1900, 3, 14));
//        System.out.println(foundPerson);

//        ArrayList<Person> foundPerson = PersonController.find(2);
//        System.out.println(foundPerson);

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Lviv");
        cities.add("Kyiv");
        ArrayList<Person> foundPerson = PersonController.find(cities);
        System.out.println(foundPerson);
    }
}
