package generics.genericFirst;

public class GenericSecond <T, Z> {
    private T field1;
    private Z field2;
    public GenericSecond(T field1, Z field2){
        this.field1 = field1;
        this.field2 = field2;
    }
    public void setField1(T field1){
        this.field1 = field1;
    }
    public void setField2(Z field2){
        this.field2 = field2;
    }
    @Override
    public String toString(){
        return "Field 1 : " + field1 + ". Field 2 : " + field2;
    }
}
