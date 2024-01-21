package streamsAPI;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products1 = new ArrayList<>();
        ArrayList<Product> products2 = new ArrayList<>();
        ArrayList<Product> products3 = new ArrayList<>();
        ArrayList<Product> products4 = new ArrayList<>();
        ArrayList<Product> products5 = new ArrayList<>();
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


        Order order1 = new Order(1, new Date(2023-1900, 1, 13), client1, manager1, products1);
        Order order2 = new Order(2, new Date(2020-1900, 11, 1), client4, manager6, products2);
        Order order3 = new Order(3, new Date(2021-1900, 6, 23), client3, manager2, products3);
        Order order4 = new Order(4, new Date(2022-1900, 8, 19), client8, manager3, products4);
        Order order5 = new Order(5, new Date(2024-1900, 2, 8), client9, manager4, products5);
    }
}
