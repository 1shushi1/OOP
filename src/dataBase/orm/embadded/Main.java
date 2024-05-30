package dataBase.orm.embadded;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Skill> skills = new ArrayList<>();
        Collections.addAll(skills, new Skill("Driving", 8), new Skill("Swimming", 3),
                new Skill("Diving", 1));
        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "555-12345", "555-67890", "555-11223");
        Employee employee = new Employee(new StaffID(32, "Cleaning"), "Max", "Verstaphen",
                Gender.MALE, 80000.0, skills, phones);
        Employee employee1 = new Employee(new StaffID(33, "Head Of The Security"), "Mykola", "Mykolenko", Gender.MALE, 55000.0, null, null);
        Employee employee2 = new Employee(new StaffID(34, "Security Worker"), "George", "Russle", Gender.MALE, 33250.0, skills, null);
        Employee employee3 = new Employee(new StaffID(35, "Cleaner"), "Tatiana", "Alabai", Gender.FEMALE, 45560.0, null, phones);
//        boolean res = EmployeeController.save(employee);
//        boolean res1 = EmployeeController.save(employee1);
//        boolean res2 = EmployeeController.save(employee2);
//        boolean res3 = EmployeeController.save(employee3);
//        if (res && res1 && res2 && res3) {
//            System.out.println("You've successfully added an employee");
//        } else {
//            System.out.println("Something goes wrong");
//        }
        EmployeeController.find(new StaffID(32, "Cleaning"));
    }
}
