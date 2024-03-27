package patterns.strategy.payStrategy;

import java.util.HashMap;
import java.util.Map;

enum OrderState {PAID, UNPAID}

public class Order {
    private String orderID;
    private String clientName;
    private String clientPhoneNumber;
    private Map<Product, Integer> products = new HashMap<>();
    private OrderState state = OrderState.UNPAID;
    public Order(){
    }

    public Order(String orderID, String clientName, String clientPhoneNumber) {
        this.orderID = orderID;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void addProduct(Product product, int amount) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + amount);
        } else {
            products.put(product, amount);
        }
    }
    public int totalPriceCalculator(){
       return products.entrySet().stream().map(e -> e.getKey().getPrice() * e.getValue()).reduce((v1, v2) -> v1 + v2).get();
    }

    public void setState(OrderState state) {
        this.state = state;
    }
    @Override
    public String toString(){
        String listOfProducts = "";
        for (Product product : products.keySet()){
            listOfProducts += product + " - " + products.get(product) + "\n";
        }
        return "OrderID : " + orderID + ". Client name : " + clientName + ". Phone number : " + clientPhoneNumber + ".\n" +
                "List of products : \n" +
                listOfProducts + "\n" +
                "State of the order : " + state + "\n" +
                "Total price : " + totalPriceCalculator();
    }
}
