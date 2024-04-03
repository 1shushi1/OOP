package patterns.momento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StateHolder {
    private Stack<Object> states = new Stack<>();
    public void addSnapshot(Object snapshot){
        states.add(snapshot);
    }
    public Object getSnapshot(){
        return states.pop();
    }
}
