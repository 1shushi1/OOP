package generics.basic;

public class OldGeneric {
    private Object field1;
    private Object field2;
    public OldGeneric(Object field1, Object field2){
        this.field1 = field1;
        this.field2 = field2;
    }
    public void setField1(Object field1){
        this.field1 = field1;
    }
    public void setField2(Object field2){
        this.field2 = field2;
    }
    @Override
    public String toString(){
        return "Field 1 : " + field1 + ". Field 2 : " + field2;
    }
}
