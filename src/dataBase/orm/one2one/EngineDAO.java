package dataBase.orm.one2one;

import java.sql.*;

public class EngineDAO implements Dao{
    private Connection connection;
    public EngineDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Entity save(Entity entity){
        Engine engine = (Engine) entity;
        String sql = "insert into engines (brand, power, type, volume) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, engine.getBrand());
            preparedStatement.setInt(2, engine.getPower());
            preparedStatement.setString(3, engine.getType());
            preparedStatement.setDouble(4, engine.getVolume());
            int save = preparedStatement.executeUpdate();
            if (save == 0){
                throw new SQLException();
            }
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                long id = rs.getLong(1);
                engine.setId(id);
                return engine;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Entity update(Entity entity){
        Engine engine = (Engine) entity;
        String sql = "update engines as e set e.brand = ?, e.type = ?, e.power = ?, e.volume = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, engine.getBrand());
            preparedStatement.setString(2, engine.getType());
            preparedStatement.setInt(3, engine.getPower());
            preparedStatement.setDouble(4, engine.getVolume());
            int update = preparedStatement.executeUpdate();
            if (update == 0){
                throw new SQLException();
            }
            return engine;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Engine find(Object id){
        String sql = "select * from engines as e where e.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, (long) id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return new Engine((long) id, rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Engine delete(Entity entity){
        Engine engine = (Engine) entity;
        String sql = "delete from engines as e where e.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, (long) engine.getId());
            int delete = preparedStatement.executeUpdate();
            if (delete == 0){
                throw new SQLException();
            }
            return engine;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
