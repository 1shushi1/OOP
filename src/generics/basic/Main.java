package generics.basic;

import generics.genericFirst.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Collections.addAll(list, 12, "Hello", 23.3);
        System.out.println(list);
        OldGeneric oldGeneric1 = new OldGeneric("First", 14);
        OldGeneric oldGeneric2 = new OldGeneric(2.4, new Date());
        System.out.println(oldGeneric1);
        System.out.println(oldGeneric2);
        oldGeneric1.setField1(88);
        oldGeneric1 = oldGeneric2;
        System.out.println(oldGeneric1);
        System.out.println(oldGeneric2);
        GenericFirst <String> genericFirst1 = new GenericFirst<>("First generic");
        GenericFirst <Integer> genericFirst2 = new GenericFirst<>(8881);
        genericFirst1.setField1("Change value");
        genericFirst2.setField1(81);
//        genericFirst1 = genericFirst2;
        GenericSecond <Integer, String> genericSecond = new GenericSecond(81, "Marshal");
        GenericClass <String, Integer> genericClass = new GenericClass<>();
        genericClass.takeType("Tolya");
        PlainClass plain = new PlainClass();
        plain.takeType("Hello world!");
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.sayHello("saying hello to you");
    }
}
