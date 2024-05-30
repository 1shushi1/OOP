package dataBase.orm.embadded;
import java.util.List;

public class Employee {
    private StaffID id;
    private String name;
    private String surname;
    private List<Skill> skills;
    private Gender gender;
    private double salary;
    private List<String> phones;
    public Employee(StaffID id, String name, String surname, Gender gender, double salary, List<Skill> skills, List<String> phones){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.skills = skills;
        this.phones = phones;
    }
    public void addSkill(Skill skill){
        skills.add(skill);
    }
    public void addPhone(String phoneNumber){
        phones.add(phoneNumber);
    }
    public void removePhone(String phoneNumber){
        phones.remove(phoneNumber);
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Employee)){
            return false;
        }
        Employee emp = (Employee) o;
        return id.equals(emp.id);
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        return hashCode * 13 + id.hashCode();
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public Gender getGender(){
        return gender;
    }
    public double getSalary(){
        return salary;
    }
    public List<String> getPhones(){
        return phones;
    }
    public List<Skill> getSkills(){
        return skills;
    }
    public StaffID getId(){
        return id;
    }
}


