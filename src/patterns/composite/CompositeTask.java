package patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task {
    private List<Task> tasks = new ArrayList<>();
    private String title;
    public CompositeTask(String title){
        this.title = title;
    }
    @Override
    public String getTitle(){
        return new String();
    }
    @Override
    public void setTitle(String title){
        this.title = title;
    }
    @Override
    public void display(){
        System.out.println(title);
        tasks.forEach(e -> e.display());
    }
    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if (o == null){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        Task task = (Task) o;
        return task.getTitle().equals(getTitle());
    }
}
