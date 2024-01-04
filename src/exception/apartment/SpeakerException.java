package exception.apartment;

public class SpeakerException extends Exception{
    private Owner owner;
    private int apartmentNumber;
    public SpeakerException(int apartmentNumber, Owner owner){
        this.apartmentNumber = apartmentNumber;
        this.owner = owner;
    }
    public String getOwner(){
        return owner.getName();
    }
    public int getApartmentNumber(){
        return apartmentNumber;
    }
}
