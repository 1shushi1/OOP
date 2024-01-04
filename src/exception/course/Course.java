package exception.course;

import java.util.ArrayList;

public class Course {
    private String title;
    private int minAmount;
    private int maxAmount;
    private boolean isStarted;
    private String professorName;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String title, int minAmount, int maxAmount, String professorName) {
        this.title = title;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.professorName = professorName;
    }

    public Course(String title, int minAmount, int maxAmount, String professorName, ArrayList<Student> students) {
        this.students = students;
        this.title = title;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.professorName = professorName;
    }

    public void add(Student s) throws CourseException {
        if (isStarted == true) {
            throw new CourseException("The course is already started");
        }
        if (students.size() == maxAmount) {
            throw new CourseException("This course is already filled with students");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(s.getName()) && students.get(i).getSurname().equals(s.getSurname())) {
                throw new CourseException("User with this name and surname already exist");
            }
        }
        students.add(s);
    }

    public void del(String name, String surname) throws CourseException {
        int counter = 0;
        if (isStarted == true) {
            throw new CourseException("You can't leave the course while it is going");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name) && students.get(i).getSurname().equals(surname)) {
                counter++;
            }
        }
        if (counter == 0){
            throw new CourseException("User doesn't exist");
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name) && students.get(i).getSurname().equals(surname)) {
                students.remove(i);
            }
        }
    }

    public void startCourse() throws CourseException {
        if (isStarted == true) {
            throw new CourseException("The course is already started");
        }
        if (students.size() < minAmount) {
            throw new CourseException("The amount of students is not enough to start a course");
        }
        if (professorName == null) {
            throw new CourseException("No professor was attached for this course");
        }
        isStarted = true;
    }

    public String getTitle() {
        return title;
    }

    public String getProfessorName() {
        return professorName;
    }
}
