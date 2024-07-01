package dataBase.orm.one2one;

import com.mysql.cj.protocol.ProtocolEntityReader;

import java.sql.*;

public class TransmissionDAO implements Dao {
    private Connection connection;
    public TransmissionDAO(Connection connection){
        this.connection = connection;
    }
    @Override
    public Transmission save(Entity entity){
        Transmission transmission = (Transmission) entity;
        String sql = "insert into gearboxes (type, speed, brand) values (?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, transmission.getType());
            preparedStatement.setInt(2, transmission.getAmountOfSpeeds());
            preparedStatement.setString(3, transmission.getBrand());
            if (preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                long id = rs.getLong(1);
                transmission.setId(id);
                connection.commit();
                return transmission;
            }
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s){
                s.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Transmission find(Object id){
        String sql = "select * from gearboxes as g where g.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, (long) id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return new Transmission((int) id, rs.getString(2), rs.getInt(3), rs.getString(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Transmission delete(Entity entity){
        Transmission transmission = (Transmission) entity;
        String sql = "delete from gearboxes as g where g.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1, (long) transmission.getId());
            if (preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            connection.commit();
            return transmission;
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s){
                s.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public Transmission update(Entity entity){
        Transmission transmission = (Transmission) entity;
        String sql = "update gearboxes as g set g.type = ?, g.speed = ?, g.brand = ? where g.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, transmission.getType());
            preparedStatement.setInt(2, transmission.getAmountOfSpeeds());
            preparedStatement.setString(3, transmission.getBrand());
            preparedStatement.setLong(4, (long) transmission.getId());
            if (preparedStatement.executeUpdate() == 0){
                throw new SQLException();
            }
            connection.commit();
            return transmission;
        } catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s){
                s.printStackTrace();
            }
        }
        return null;
    }
}
