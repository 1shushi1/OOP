package streamsAPI;

public class Client implements Comparable<Client>{
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
    public String getFirstName(){
        return firstName;
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Client)){
            return false;
        }
        Client client = (Client) o;
        return client.firstName.equals(firstName) && client.lastName.equals(lastName);
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        hashCode += 13 + firstName.hashCode();
        hashCode += 13 + lastName.hashCode();
        return hashCode;
    }
    @Override
    public int compareTo(Client client){
        return firstName.compareTo(client.firstName);
    }
}
