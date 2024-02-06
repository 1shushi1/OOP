package streamsAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderController {
    //приймаємо список замовлень, позбавляємося дублікатів та друкуємо список
    public static void deleteDuplicate(List<Order> orders){
        Stream<Order> stream = orders.stream();
        Stream<Order> withOutDuplicatesStr = stream.distinct();
        withOutDuplicatesStr.forEach(e -> System.out.println(e));
    }
    //приймаємо масив замовлень та відкриваємо стрім та позбавляємось дублікатів та повертаємо кількість унікальних замовлень
    public static int uniqueOrders(Order [] orders){
        Stream<Order> stream = Arrays.stream(orders);
        Stream<Order> uniqueVal = stream.distinct();
        long uniqValCounter = uniqueVal.count();
        return (int) uniqValCounter;
    }
    //приймаємо лист замовлень та повертаємо лист без дублікатів
    public static List<Order> duplicateDelFromList(List<Order> orders){
        return orders.stream()
                .distinct()
                .toList();
    }
    //приймаємо замовлення , позбавляємося дублікатів та повертаємо замовлення з загальними сумами що перевищують ту що передається в метод
    public static List<Order> sumComp(List<Order> orders, double price){
        return orders.stream().distinct().filter(order -> order.totalPrice() > price).toList();
    }
    //приймаємо замовлення та клієнта та повертаємо всі замовлення цього клієнта без повторів
    public static List<Order> clientChecker (List<Order> orders, Client client){
        return orders.stream().distinct().filter(o -> o.getClient().equals(client)).toList();
    }
    //приймаємо замовлення та повертаємо вартість всіх замовлень
    public static double priceOfAllOrd(List<Order> orders){
        double [] sum = new double[1];
        orders.stream().distinct().forEach(o -> sum[0] += o.totalPrice());
        return sum[0];
    }
    //приймаємо список замовлень та діапазон дат та повертаємо всі замовлення цього діапазона
    public static List<Order> dateSorting(List<Order> orders, Date dateFrom, Date dateTo){
        return orders.stream().distinct().filter(o -> o.getDate().before(dateTo) && o.getDate().after(dateFrom)).toList();
    }
    //приймаємо замовлення та список клієнтів та повертаємо замовлення клієнтів, яких немає в цьому black list
    public static List<Order> blackList (List<Order> orders, List<Client> blackListClients){
        return orders.stream().distinct().filter(o -> !blackListClients.contains(o.getClient())).toList();
    }
    //приймаємо замовлення та повертаємо відсортовані за іменами клієнтів замовлення
    public static List<Order> nameSorted(List<Order> orders){
        //two ways of solving this problem
//        return orders.stream().distinct().sorted(Comparator.comparing(o -> o.getClient().getFirstName())).toList();
        return orders.stream().distinct().sorted((a, b) -> a.getClient().getFirstName().compareTo(b.getClient().getFirstName())).toList();
    }
    // відсортувати список замовлень за спаданням дат але не використ компаратор
    public static List<Order> sortedByDate(List<Order> orders){
        return orders.stream().distinct().sorted().toList();
    }
    //знайти саме коштовне замовлення в такий-то період
    public static Order theMostExpOrd(List<Order> orders, Date dateFrom, Date dateTo){
        return orders.stream().distinct().filter(o -> o.getDate().before(dateTo) && o.getDate().after(dateFrom))
                .max((o1, o2) -> Double.compare(o1.totalPrice(), o2.totalPrice())).get();
    }
    //знайти та повернути найдорожчий товар
    public static Product theMostExpensiveProd(List<Order> orders){
        return orders.stream().max(((o1, o2) -> Double.compare(o1.theMostExpProduct().getPrice(), o2.theMostExpProduct().getPrice()))).get().theMostExpProduct();
    }
    //приймаэмо замовлення та повертаємо клієнта, що зробив найдешевше замовлення починаючи з дати, що передається
    public static Client theCheapestOrderByDate(List<Order> orders, Date dateFrom, Date dateTo){
        return orders.stream()
                .distinct()
                .filter(o -> o.getDate().before(dateTo) && o.getDate().after(dateFrom))
                .min((o1, o2) -> Double.compare(o1.totalPrice(), o2.totalPrice()))
                .get()
                .getClient();
    }

    //приймаємо замовлення та повертаємо список менеджерів, що працюють на фірмі
    public static List<Manager> listOfManagers(List<Order> orders){
        return orders.stream()
                .map(o -> o.getManager())
                .distinct()
                .toList();
    }

    //приймаємо замовлення та повертаємо загальну суму замовлень використовуючи метод редюс
    public static Double totalPriceReduce(List<Order> orders){
        return orders.stream()
                .distinct()
                .map(o -> o.totalPrice())
                .reduce((o1, o2) -> Double.sum(o1, o2)).get();
    }
    //приймаємо замовлення на повертаємо відсортовані по абетці клієнтів
    public static List<Client> sortedAlpClients(List<Order> orders){
        return orders.stream()
                .map(o -> o.getClient())
                .distinct()
                .sorted().toList();
    }
    //повернути список товарів що продає фірма
    public static List<Product> listOfProduct(List<Order> orders){
        return orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .toList();
    }
}
