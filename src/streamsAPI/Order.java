package streamsAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderID;
    private Date date;
    private Client client;
    private Manager manager;
    private List<Product> products = new ArrayList<>();
    public Order(int orderID, Date date, Client client, Manager manager, List<Product> products){
        this.orderID = orderID;
        this.date = date;
        this.client = client;
        this.manager = manager;
        this.products = products;
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Getter and Setter for manager
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Invoice number : " + orderID + " from " + date + "\n" +
                                                  "Performer of the order : " + manager + "\n" +
                                                  "Buyer : " + client + "\n" +
                                                  "List of product : \n");
       products.forEach((e) -> builder.append(e + "\n"));
       return builder.toString();
    }
}
