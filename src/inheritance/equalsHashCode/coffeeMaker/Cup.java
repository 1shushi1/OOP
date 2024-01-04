package inheritance.equalsHashCode.coffeeMaker;

import java.util.HashMap;

public class Cup {
    private HashMap<Ingredient, Integer> ingredients = new HashMap<>();
    public void putIngredients(Ingredient ingredient, Integer amount){
        ingredients.put(ingredient, amount);
    }
    @Override
    public String toString(){
        String list = "";
        double totalPrice = 0;
        for (Ingredient ingredient : ingredients.keySet()){
            totalPrice += ingredient.getPrice()*ingredients.get(ingredient);
            list += ingredient + " - " + ingredients.get(ingredient)+ " portion" + "\n";
        }
       return list + "\n" + "Total price : " + Math.round(totalPrice);
    }
}
