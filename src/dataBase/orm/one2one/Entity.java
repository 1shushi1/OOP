package dataBase.orm.one2one;

public abstract class Entity {
    private Object id;
    public Entity(Object id){
        this.id = id;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (this == null){
            return false;
        }
        if (o.getClass() != this.getClass()){
            return false;
        }
        Entity entity = (Entity) o;
        return entity.id.equals(id);
    }
    @Override
    public int hashCode(){
        int hashCode = 13;
        return hashCode + 13 * id.hashCode();
    }
    public Object getId(){
        return id;
    }
    @Override
    public String toString(){
        return "Id : " + id;
    }
    public void setId(Object id){
        this.id = id;
    }
}
