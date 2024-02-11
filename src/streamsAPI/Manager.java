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
        return "Name : " + firstName + " | Surname : " + lastName + " | Phone number : " + phoneNumber;
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Manager)){
            return false;
        }
        Manager manager = (Manager) o;
        return firstName.equals(manager.firstName) && lastName.equals(manager.lastName);
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode += 13 + firstName.hashCode();
        return hashCode += 13 + lastName.hashCode();
    }
}
