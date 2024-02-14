package streamsAPI;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products1 = new ArrayList<>();
        ArrayList<Product> products2 = new ArrayList<>();
        ArrayList<Product> products3 = new ArrayList<>();
        ArrayList<Product> products4 = new ArrayList<>();
        ArrayList<Product> products5 = new ArrayList<>();
        ArrayList<Product> products6 = new ArrayList<>();
        ArrayList<Product> products7 = new ArrayList<>();
        products1.add(new Product("Laptop", 999.99, 5));
        products1.add(new Product("Smartphone", 499.99, 7));
        products1.add(new Product("Coffee Maker", 39.99, 8));
        products1.add(new Product("Fitness Tracker", 129.99, 6));

        products2.add(new Product("Camera", 299.99, 5));
        products2.add(new Product("Wireless Mouse", 19.99, 8));
        products2.add(new Product("External Hard Drive", 89.99, 3));
        products2.add(new Product("Bluetooth Speaker", 49.99, 6));
        products2.add(new Product("Gaming Keyboard", 79.99, 4));


        products3.add(new Product("Tablet", 199.99, 4));
        products3.add(new Product("Desk Lamp", 29.99, 6));
        products3.add(new Product("Fitness Mat", 19.99, 10));

        products4.add(new Product("Carpet", 19.99, 3));

        products5.add(new Product("Case IPhone 15 Pro Max", 25.99, 4));
        products5.add(new Product("Smartwatch", 129.99, 2));
        products5.add(new Product("Coffee Grinder", 29.99, 7));

        products6.add(new Product("Fitness Tracker", 89.99, 8));
        products6.add(new Product("Laptop Stand", 34.99, 4));
        products6.add(new Product("Travel Pillow", 19.99, 9));
        products6.add(new Product("Stainless Steel Water Bottle", 14.99, 10));

        products7.add(new Product("Wireless Earbuds", 79.99, 5));
        products7.add(new Product("Portable Bluetooth Speaker", 49.99, 3));
        products7.add(new Product("Electric Toothbrush", 39.99, 6));

        Client client1 = new Client("John", "Doe", "123 Main St", "555-1234");
        Client client2 = new Client("Alice", "Smith", "456 Oak St", "555-5678");
        Client client3 = new Client("Bob", "Johnson", "789 Pine St", "555-9101");
        Client client4 = new Client("Eva", "Williams", "101 Elm St", "555-1122");
        Client client5 = new Client("David", "Jones", "202 Maple St", "555-3344");
        Client client6 = new Client("Sophia", "Brown", "303 Cedar St", "555-5566");
        Client client7 = new Client("Michael", "Miller", "404 Birch St", "555-7788");
        Client client8 = new Client("Olivia", "Davis", "505 Spruce St", "555-9900");
        Client client9 = new Client("Daniel", "Garcia", "606 Pine St", "555-1122");
        Client client10 = new Client("Emma", "Taylor", "707 Oak St", "555-3344");

        Manager manager1 = new Manager("John", "Doe", "555-1234");
        Manager manager2 = new Manager("Alice", "Smith", "555-5678");
        Manager manager3 = new Manager("Bob", "Johnson", "555-9101");
        Manager manager4 = new Manager("Eva", "Williams", "555-1122");
        Manager manager5 = new Manager("David", "Jones", "555-3344");
        Manager manager6 = new Manager("Sophia", "Brown", "555-5566");
        Manager manager7 = new Manager("Michael", "Miller", "555-7788");

        Manager manager8 = new Manager("Bob", "Johnson", "555-9101");

        Order order1 = new Order(1, new Date(2023-1900, 1, 13), client1, manager1, products1);
        Order order2 = new Order(2, new Date(2020-1900, 11, 1), client4, manager6, products2);
        Order order3 = new Order(3, new Date(2021-1900, 6, 23), client3, manager2, products3);
        Order order4 = new Order(4, new Date(2022-1900, 8, 19), client8, manager3, products4);
        Order order5 = new Order(5, new Date(2024-1900, 2, 8), client9, manager8, products5);
        Order order6 = new Order(6, new Date(2024-1900, 7, 12), client9, manager4, products6);
        Order order7 = new Order(7, new Date(2024-1900, 4, 19), client9, manager4, products7);
        Order order8 = new Order(7, new Date(2024-1900, 4, 19), client9, manager4, products7);
        Order order9 = new Order(4, new Date(2022-1900, 8, 19), client8, manager3, products4);

        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders, order1, order2, order3, order4, order5, order6, order7, order1, order3, order5, order8, order9);

//        checker of how stream deletes duplicated from list
//      orders.forEach(e -> System.out.println(e));
//        OrderController.deleteDuplicate(orders);
//
//        //check of how stream remove duplicates from array and return amount of uniq val
////        Order [] ordersArr = new Order[]{order1, order2, order3, order4, order5, order6, order7, order8, order9};
//        Order [] ordersArr = orders.toArray(new Order[0]);
//        int val = OrderController.uniqueOrders(ordersArr);
//        System.out.println(val);

//        //checker of how stream remove duplicates from list and return list without duplicates
//        List<Order> orderList = OrderController.duplicateDelFromList(orders);
//        orderList.forEach(e -> System.out.println(e));

//        //checker of how stream remove duplicates from list, compare it with a price and return a new list
//        List<Order> orders1 = OrderController.sumComp(orders, 1000);
//        orders1.forEach(e -> System.out.println(e));

//        checker of how stream remove duplicates from list, and shows all orders of one client and return new list without unnecessary orders
//        List<Order> ordersList2 = OrderController.clientChecker(orders, client9);
//        ordersList2.forEach(e -> System.out.println(e));

        //checker of how stream count double values and find a total sum of all orders
//        double price = OrderController.priceOfAllOrd(orders);
//        System.out.println("Price of all orders : " + price);

        //checker of how stream filters orders with different dates in range
//        List<Order> orderListy = OrderController.dateSorting(orders, new Date(2024-1900, 3, 1), new Date(2024-1900, 8, 25 ));
//        orderListy.forEach(e -> System.out.println(e));

        //checker whether list contains client which is in the black list
//        List<Client> clients = new ArrayList<>();
//        Collections.addAll(clients, client1, client4, client8);
//        List<Order> orderBlackList = OrderController.blackList(orders, clients);
//        orderBlackList.forEach(e -> System.out.println(e));

        //checker how it sorts List by names
//        List<Order> ordersByName = OrderController.nameSorted(orders);
//        ordersByName.forEach(o -> System.out.println(o));

        //checker how stream sorts without comparator, only using comparable interface
//        List<Order> sortedByDate = OrderController.sortedByDate(orders);
//        sortedByDate.forEach(o -> System.out.println(o));

        //checker how stream finds the most expensive order in a certain time
//        Order order = OrderController.theMostExpOrd(orders, new Date(2024-1900, 2, 1), new Date(2024-1900, 8, 25));
//        System.out.println(order);

        //checker how stream find the most expensive product within all orders
//        Product product = OrderController.theMostExpensiveProd(orders);
//        System.out.println(product);

        //checker how stream find the cheapest order on a particular date period and return client info
//        Client client = OrderController.theCheapestOrderByDate(orders,new Date(2020-1900, 11, 1),new Date(2024-1900, 7, 25) );
//        System.out.println(client);

        //checker how stream find all managers within orders
//        List<Manager> managers = OrderController.listOfManagers(orders);
//        managers.forEach(m -> System.out.println(m));

        //checker how stream find return total sum of all orders using reduce
//        Double sum = OrderController.totalPriceReduce(orders);
//        System.out.println(Math.round(sum * 1000)/1000.0);

        //checker of how stream sorting client alphabetically
//        List<Client> clientsList = OrderController.sortedAlpClients(orders);
//        clientsList.forEach(c -> System.out.println(c));

        //checker of how stream shows all products that company sell
//        List<Product> productsList = OrderController.listOfProduct(orders);
//        productsList.forEach(e -> System.out.println(e));

        //checker list of products ASC by price
//        List<Product> products = OrderController.sortedProductsByPriceASC(orders);
//        products.forEach(p -> System.out.println(p));

//        System.out.println("______________________");

        //checker of how stream find the cheapest product that was selling
//        Product product = OrderController.theCheapestProduct(orders);
//        System.out.println(product);

        //check totalPrices
//        List<Order> orderList = OrderController.totalPrice(orders);
//        orderList.forEach(e -> System.out.println(e));

        //checker of how stream return the total price of orders which have particular products that was pass as a List<Product>
//        List<Product> particularProducts = new ArrayList<>();
//        Collections.addAll(particularProducts, new Product("Carpet", 19.99, 3), new Product("Wireless Earbuds", 79.99, 5));
//        double [] sum = OrderController.totalPriceOfOrdByPartGoods(orders, particularProducts);
//        System.out.println(Arrays.toString(sum));

        //checker of how stream summing particular products in order
//        double sum = OrderController.priceOfPartProduct(orders, particularProducts);
//        System.out.println(Math.round(sum * 1000)/1000.0);

        //checker of how stream counts clients order amounts
//        Map<Product, Long> productLongMap = OrderController.amountOfSoldProductsTable(orders);
//        for (Product product : productLongMap.keySet()){
//            System.out.println(product + " - " + productLongMap.get(product));
//        }

//        List<Product> productsList = OrderController.listOfProduct(orders);
//        productsList.forEach(e -> System.out.println(e));

        //checker of how stream makes a table for manager and their sales
//        HashMap<Manager, Double> earnedMoney = OrderController.moneyEachManagerMadeForAllOrders(orders);
//        for (Manager manager : earnedMoney.keySet()) {
//            System.out.println(manager + " - " + earnedMoney.get(manager));
//        }

        //checker of how stream finds all orders for each client (Client - Orders)
//        HashMap<Client, List<Order>> clientOrders = OrderController.allClientOrders(orders);
//        for (Map.Entry<Client, List<Order>> entry : clientOrders.entrySet()){
//            Client client = entry.getKey();
//            List<Order> ordersList = entry.getValue();
//            for (Order order : ordersList){
//                System.out.println(client + " - " + order);
//            }
//        }
    }
}
