package dataBase.orm.one2one;

public interface Dao {
    Entity save(Entity entity);
    Entity find(Object id);
    Entity delete(Entity entity);
    Entity update(Entity entity);
}
