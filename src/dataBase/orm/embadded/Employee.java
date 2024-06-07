package dataBase.orm.embadded;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private StaffID id;
    private String name;
    private String surname;
    private List<Skill> skills = new ArrayList<>();
    private Gender gender;
    private double salary;
    private List<String> phones = new ArrayList<>();
    public Employee(StaffID id, String name, String surname, Gender gender, double salary, List<Skill> skills, List<String> phones){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
        this.skills = skills;
        this.phones = phones;
    }
    public Employee(StaffID id, String name, String surname, Gender gender, double salary){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.salary = salary;
    }
    public void addSkill(Skill skill){
        if (skill != null && !(skills.contains(skill))){
            skills.add(skill);
        }
    }
    public void addPhone(String phoneNumber){
        if (phoneNumber != null && !(phones.contains(phoneNumber))){
            phones.add(phoneNumber);
        }
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
    @Override
    public String toString(){
        String phone = "";
        String skill = "";
        for (int i = 0; i < skills.size(); i++) {
            skill += "Title : " + skills.get(i).getTitle() + " - Experience : " + skills.get(i).getExperience() + "\n";
        }
        for (int i = 0; i < phones.size(); i++) {
            phone += "Phone number : " + phones.get(i) + "\n";
        }
        return "ID : " + id.getId() + ". \nDepartment : " + id.getDepartment() + ". \nName : " + name + ". \nSurname : " + surname + ". \nGender : " + gender + ". \nSalary : " + salary +
                ". \nSkills : \n" + skill + "Phones : \n" + phone;
    }
}


