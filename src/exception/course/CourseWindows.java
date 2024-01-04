package exception.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CourseWindows {
    private ArrayList<Course> coursesList;
    private Scanner s = new Scanner(System.in);
    private String passwordStat = "start.course";
    private String usernameStat;
    private int currentCourse;

    public CourseWindows() {
        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students,
                new Student("Sasha", "Johnson"),
                new Student("Ella", "Smith"),
                new Student("Liam", "Williams"),
                new Student("Olivia", "Jones"),
                new Student("Noah", "Brown"),
                new Student("Ava", "Davis"),
                new Student("Mia", "Miller"),
                new Student("Ethan", "Wilson"),
                new Student("Isabella", "Moore"),
                new Student("Lucas", "Taylor"),
                new Student("Emma", "Anderson"),
                new Student("Jackson", "Thomas"),
                new Student("Sophia", "Harris"),
                new Student("Aiden", "Martin"),
                new Student("Chloe", "White")
        );
        ArrayList<Student> students1 = new ArrayList<>();
//        Collections.addAll(students1,
//                new Student("Sasha", "Johnson"),
//                new Student("Ella", "Smith"),
//                new Student("Liam", "Davis"),
//                new Student("Olivia", "Anderson"),
//                new Student("Noah", "Wilson"),
//                new Student("Ava", "Miller"),
//                new Student("Mia", "Garcia"),
//                new Student("Ethan", "Brown"),
//                new Student("Isabella", "Lee"),
//                new Student("Lucas", "Harris"),
//                new Student("Emma", "Clark"),
//                new Student("Jackson", "Turner"),
//                new Student("Sophia", "Mitchell"),
//                new Student("Aiden", "Scott"),
//                new Student("Chloe", "White"),
//                new Student("Grace", "Martin"),
//                new Student("Henry", "Turner"),
//                new Student("Zoe", "Harris"),
//                new Student("Carter", "Davis"),
//                new Student("Mila", "Johnson")
//        );
        coursesList = new ArrayList<>();
        Course course = new Course("Java", 5, 20, "Tomash", students1);
        coursesList.add(course);
        Course course1 = new Course("C++", 5, 15, "Olivia", students);
        coursesList.add(course1);
        menu();
    }

    public void menu() {
        try {
            System.out.println("Select a number : 1 - to add a student, 2 - to start a course, 3 - to delete student from a group");
            int selection = Integer.parseInt(s.nextLine());
            switch (selection) {
                case 1 -> add();
                case 2 -> start();
                case 3 -> del();
            }
        } catch (CourseException e) {
            System.out.println("WARNING!!!\n" + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Incorrect data");
        }
        menu();
    }

    private void add() throws CourseException {
        System.out.println("Enter a student name");
        String name = s.nextLine();
        System.out.println("Enter a student surname");
        String surname = s.nextLine();
        Student student = new Student(name, surname);
        selectFromCurrentCourse();
        coursesList.get(currentCourse).add(student);
        System.out.println("Student was added");
    }

    private void selectFromCurrentCourse() {
        System.out.println("Select a course from the list");
        for (int i = 0; i < coursesList.size(); i++) {
            System.out.println(i + " - " + coursesList.get(i).getTitle());
        }
        currentCourse = Integer.parseInt(s.nextLine());
    }

    private void del() throws CourseException {
        System.out.println("Enter a student name you would like to remove from the course");
        String name = s.nextLine();
        System.out.println("Enter a student surname you would like to remove from the course");
        String surname = s.nextLine();
        selectFromCurrentCourse();
        coursesList.get(currentCourse).del(name, surname);
        System.out.println("Student was removed");
    }

    private void start() throws CourseException {
        System.out.println("Enter your username");
        usernameStat = s.nextLine();
        System.out.println("Enter your password");
        String password = s.nextLine();
        selectFromCurrentCourse();
        if (coursesList.get(currentCourse).getProfessorName().equals(usernameStat) && password.equals(passwordStat)) {
            coursesList.get(currentCourse).startCourse();
            System.out.println("Course was started successfully");
        } else {
            System.out.println("Fail");
        }
    }
}

