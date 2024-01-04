package collections.arrayListRevision;

public class Person {
    private String name;
    private String surname;
    private int age;
    public Person(String name, String surname, int age){
        this.name = name;
        this.age = age;
        this.surname = surname;
    }
    public int getAge(){
        return age;
    }
    public void info(){
        System.out.println("Name : " + name + ". Surname : " + surname + ". Age :  " + age );
    }
}
