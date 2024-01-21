package streamsAPI;

public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    public Client(String firstName, String lastName, String address, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String toString(){
        return "Name : " + firstName + "| Surname : " + lastName + "| Address : " + address + "| Phone number : " + phoneNumber;
    }
}
