package streamsAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order>{
    private long orderID;
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
    public long getOrderID() {
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
    public double totalPrice(){
        final double [] arr = new double[1];
        products.forEach(e -> arr[0] += e.getTotalPrice());
        return arr[0];
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("Invoice number : " + orderID + " from " + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n" +
                                                  "Performer of the order : " + manager + "\n" +
                                                  "Buyer : " + client + "\n" +
                                                  "List of product : \n");
       products.forEach((e) -> builder.append(e + "\n"));
       builder.append("Total price for all products : " + totalPrice() + "\n");
       return builder.toString();
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Order)){
            return false;
        }
        Order order = (Order) o;
        return order.orderID == orderID;
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        return hashCode += 13 + Long.hashCode(orderID);
    }
    @Override
    public int compareTo(Order order){
        //in order to get a desc order we can use - before the statement
        //we can change places, example : order.date.compareTo(date);
        return -date.compareTo(order.date);
    }
    public Product theMostExpProduct(){
        return products.stream().max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
    }
    public List<Product> getProducts(){
        return products;
    }
}
