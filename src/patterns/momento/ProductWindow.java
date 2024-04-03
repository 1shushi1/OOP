package patterns.momento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductWindow {
    private Scanner s = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    private int index = 0;
    private StateHolder stateHolder = new StateHolder();

    public ProductWindow() {
        products.add(new Product(1, "Wireless Bluetooth Headphones", "Sony", 99.99, 50, 4, new Date(2022 - 1990, 5, 23)));
        products.add(new Product(2, "Smartphone", "Samsung", 599.99, 100, 5, new Date(2023 - 1990, 3, 6)));
        products.add(new Product(3, "Laptop", "Dell", 899.99, 30, 4, new Date(2022 - 1990, 1, 13)));
        products.add(new Product(4, "Smart Watch", "Apple", 299.99, 80, 4, new Date(2024 - 1990, 8, 16)));
        products.add(new Product(5, "Wireless Mouse", "Logitech", 49.99, 120, 5, new Date(2024 - 1990, 7, 18)));
        menu();
    }

    public void menu() {
        while (true) {
            System.out.println("=============Menu=============");
            System.out.println(products.get(index));
            System.out.println("1. Undo");
            System.out.println("2. Left");
            System.out.println("3. Right");
            System.out.println("4. Edit product");
            System.out.println("5. Exit");
            System.out.println("Enter number :");
            int sel = Integer.parseInt(s.nextLine());
            switch (sel) {
                case 1 -> undo();
                case 2 -> left();
                case 3 -> right();
                case 4 -> edit();
                case 5 -> System.exit(0);
            }
        }
    }

    private void left() {
        if (index == 0) {
            index = products.size() - 1;
        } else {
            index -= 1;
        }
    }

    private void right() {
        if (index == products.size() - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    private void undo() {
        Object object = stateHolder.getSnapshot();
        if (object != null) {
            products.get(index).setMomento(object);
            System.out.println("Updated info");
            System.out.println(products.get(index));
        } else {
            System.out.println("Updated info");
            System.out.println(products.get(index));
        }
    }

    private void edit() {
        stateHolder.addSnapshot(products.get(index).getMomento());
        while (true) {
            System.out.println("============Edit Menu============");
            System.out.println("Enter number : ");
            System.out.println("1. Name");
            System.out.println("2. Brand");
            System.out.println("3. Price");
            System.out.println("4. Amount");
            System.out.println("5. Rating");
            System.out.println("6. Date");
            System.out.println("7. Exit");
            int sel = Integer.parseInt(s.nextLine());
            switch (sel) {
                case 1:
                    System.out.println("Enter new name : ");
                    products.get(index).setName(s.nextLine());
                    break;
                case 2:
                    System.out.println("Enter new brand : ");
                    products.get(index).setBrand(s.nextLine());
                    break;
                case 3:
                    System.out.println("Enter new price : ");
                    products.get(index).setPrice(Double.parseDouble(s.nextLine()));
                    break;
                case 4:
                    System.out.println("Enter new amount : ");
                    products.get(index).setAmount(Integer.parseInt(s.nextLine()));
                    break;
                case 5:
                    System.out.println("Enter new rating : ");
                    products.get(index).setRating(Integer.parseInt(s.nextLine()));
                    break;
                case 6:
                    System.out.println("Enter new year : ");
                    int year = Integer.parseInt(s.nextLine());
                    System.out.println("Enter month :");
                    int month = Integer.parseInt(s.nextLine());
                    System.out.println("Enter day : ");
                    int day = Integer.parseInt(s.nextLine());
                    products.get(index).setDate(new Date(year - 1900, month, day));
                    break;
                case 7 : menu();
                default:
                    System.out.println("Invalid number");
            }
            stateHolder.addSnapshot(products.get(index).getMomento());
        }
    }
}
