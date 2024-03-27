package patterns.strategy.payStrategy;

import java.util.ArrayList;
import java.util.List;

public class StorageController {
    private List<Order> storage = new ArrayList<>();
    public void putToStorage(Order order){
        storage.add(order);
        System.out.println("Your order was successfully put to storage");
    }
}
