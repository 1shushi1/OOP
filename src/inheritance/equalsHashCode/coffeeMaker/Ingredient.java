package inheritance.equalsHashCode.coffeeMaker;

public abstract class Ingredient {
    private double price;
    private double weight;
    public Ingredient(double price, double weight){
        this.price = price;
        this.weight = weight;
    }
    public double getPrice(){
        return price;
    }
    public double getWeight(){
        return weight;
    }
    @Override
    public String toString(){
        return getClass().getSimpleName() + " - " + price + " euro." + " " + weight + " ml";
    }
    @Override
    public boolean equals(Object object){
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        // instaceof - перевіряє чи змінна має такий тип
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Ingredient ingredient = (Ingredient) object;
        if (weight == ingredient.weight && price == ingredient.price) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        int hashCode = 1;
        hashCode = 1 * hashCode + Double.hashCode(price);
        hashCode = 1 * hashCode + Double.hashCode(weight);
        return hashCode;
    }
}
