package inheritance.basicInfo;

public abstract class Bird extends Animal{
    private int flyingHeight;
    private boolean hasFeather;
    public Bird(String name, String type, String color, double weight, int size, int flyingHeight, boolean hasFeather){
        super (name, type, color, weight, size); //якщо батьківський клас має конструктор, то викликаємо super,
                                                // проініціалізувати змінні, які в батьківському класі
        this.flyingHeight = flyingHeight;
        this.hasFeather = hasFeather;
    }
    public int getFlyingHeight(){
        return flyingHeight;
    }
    public boolean isHasFeather(){
        return hasFeather;
    }
    public final void toEat(String food){
        System.out.println(getClass().getSimpleName() + food);
    }
}
