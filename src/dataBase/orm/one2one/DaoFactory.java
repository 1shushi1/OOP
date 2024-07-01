package dataBase.orm.one2one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private Connection connection;
    private static DaoFactory daoFactory = new DaoFactory();

    private DaoFactory() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public Dao getDao(String type) {
        if (type.equalsIgnoreCase("engine")) {
            return new EngineDAO(connection);
        }
        if (type.equalsIgnoreCase("transmission")){
            return new TransmissionDAO(connection);
        }
        if (type.equalsIgnoreCase("car")){
            return new CarDAO(connection);
        }
        return null;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
