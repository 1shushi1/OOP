package streamsAPI;

public class Manager {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    public Manager(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return "Name : " + firstName + "| Surname : " + lastName + "| Phone number : " + phoneNumber;
    }
}
