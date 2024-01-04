package exception.apartment;

import java.util.Scanner;

public class Apartment {
    private Speaker speaker;
    private Owner owner;
    private int apartmentNumber;
    private Scanner s = new Scanner(System.in);

    public Apartment(String name, int apartmentNumber) {
        speaker = new Speaker();
        owner = new Owner(name);
        this.apartmentNumber = apartmentNumber;
    }

    class Speaker {
        public void call() throws SpeakerException {
            SpeakerException speakerException = new SpeakerException(apartmentNumber, owner);
            throw speakerException;
        }
    }
    public void call() throws SpeakerException{
        speaker.call();
    }
    public int getApartmentNumber(){
        return apartmentNumber;
    }
}
