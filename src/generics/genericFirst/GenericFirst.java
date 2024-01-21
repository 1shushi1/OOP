package generics.genericFirst;

public class GenericFirst <T> {
    private T field1;
    public GenericFirst(T field1){
        this.field1 = field1;
    }
    public void setField1(T field1){
        this.field1 = field1;
    }
    public String toString(){
        return "Field 1 : " + field1;
    }
}
