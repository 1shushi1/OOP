package patterns.composite;

public class SimpleTask implements Task {
    private String title;
    public SimpleTask(String title){
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
    }
}
