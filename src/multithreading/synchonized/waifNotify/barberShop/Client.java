package multithreading.synchonized.waifNotify.barberShop;

public class Client {
    private int id;
    private long enteringTime;
    public Client(int id){
        this.id = id;
    }
    @Override
    public String toString(){
        return "ID : " + id;
    }
    public void setEnteringTime(long enteringTime){
        this.enteringTime = enteringTime;
    }
    @Override
    public boolean equals(Object object){
        if (object == this){
            return true;
        }
        if (object == null){
            return false;
        }
        if (!(object instanceof Client)){
            return false;
        }
        Client client = (Client) object;
        return client.id == id;
    }
}
