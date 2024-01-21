package generics.animal;

import java.util.ArrayList;

public class GenericZoo <T extends Animal>{
    private ArrayList<T> animals = new ArrayList<>();
    public void add(T t){
        animals.add(t);
    }
    public void remove(T t){
        animals.remove(t);
    }
    public void voice(){
        for (T t : animals){
            t.voice();
        }
    }
}
