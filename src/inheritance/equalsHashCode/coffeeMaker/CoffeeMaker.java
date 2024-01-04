package inheritance.equalsHashCode.coffeeMaker;
import java.util.Scanner;
import java.util.HashMap;

public class CoffeeMaker {
    private HashMap<Ingredient, Integer> storage = new HashMap<>();
    private Scanner s = new Scanner(System.in);
//    private int extraSugar;
    public CoffeeMaker(){
        storage.put(new Milk(), 10);
        storage.put(new Sugar(), 25);
        storage.put(new Water(), 40);
        storage.put(new Coffee(), 100);
    }
    public void fillStorage(){
        System.out.println("Enter a product name you would like to refill");
        String productName = s.next();
        Ingredient ingredient = null;
        if (productName.equalsIgnoreCase("Milk")){
            ingredient = new Milk();
        }
        if (productName.equalsIgnoreCase("Coffee")){
            ingredient = new Coffee();
        }
        if (productName.equalsIgnoreCase("Water")){
            ingredient = new Water();
        }
        else {
            ingredient = new Sugar();
        }
        System.out.println("Enter an amount you would like to fill " + "\nAmount must not be bigger than 100");
        int amount = s.nextInt();
        if (amount <= 100){
            storage.put(ingredient, amount);
        }

    }
    public void makeDrink(){
        System.out.println("Enter drink you would like to have");
        String drink = s.next();
        switch (drink) {
            case "latte" -> latte();
            case "americano" -> americano();
//            case "sugar" -> addSugar();
        }
    }
    public void latte(){
        //in order to make latte we need water - 50 ml, milk 30ml and coffee - 20ml
        Integer milkAmount = storage.get(new Milk());
        Integer waterAmount = storage.get(new Water());
        Integer coffeeAmount = storage.get(new Coffee());
        Integer sugarAmount = storage.get(new Sugar());
        if (milkAmount >= 1 && waterAmount >= 1 && coffeeAmount >= 1 && sugarAmount >= 1){
                Cup cup = new Cup();
                cup.putIngredients(new Milk(), 1);
                cup.putIngredients(new Water(), 1);
                cup.putIngredients(new Coffee(), 1);
                cup.putIngredients(new Sugar(), 1);
                System.out.println(cup);
        } else {
            System.out.println("Not enough products in machine");
        }
    }
//    public void addSugar(){
//        System.out.println("Enter amount of sugar you would like to add");
//        extraSugar = s.nextInt();
//        Integer sugarAmount = storage.get(new Sugar());
//        if (sugarAmount >= extraSugar){
//        }
//    }
    public void americano(){
        Integer waterAmount = storage.get(new Water());
        Integer coffeeAmount = storage.get(new Coffee());
        Integer sugarAmount = storage.get(new Sugar());
        if (waterAmount >= 1 && coffeeAmount >= 2 && sugarAmount >= 1){
            Cup cup = new Cup();
            cup.putIngredients(new Water(), 1);
            cup.putIngredients(new Coffee(), 2);
            cup.putIngredients(new Sugar(), 1);
            System.out.println(cup);
        } else {
            System.out.println("Not enough products in machine");
        }
    }
}
