package dataBase.orm.one2one;

import java.sql.*;

public class CarController {
    //save
    public static boolean save(Car car){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11")){
            StringBuilder sb = new StringBuilder();
            sb.append("('" + car.getBrand() + "', ");
            sb.append("'" + car.getModel() + "', ");
            sb.append(car.getYear() + ", ");
            if (car.getEngine() == null) {
                sb.append("NULL");
            } else {
                sb.append(car.getEngine().getId());
            }
            sb.append(");");
            String sql = "insert into cars (brand, model, year, engine_id) values " + sb;
            Statement statement = connection.createStatement();
            if (statement.executeUpdate(sql) != 0) {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    //delete
    public static boolean delete(Object id){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11")){
            String sql = "delete from cars as c where c.id = " + id;
            Statement statement = connection.createStatement();
            if (statement.executeUpdate(sql) == 0){
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    //find
    public static Car find(Object id) {
        Car car = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11")) {
            String sql = "SELECT c.id, c.brand, c.model, c.year, e.id, e.brand, e.power, e.type, e.volume " +
                    "FROM cars AS c " +
                    "LEFT JOIN engines AS e ON c.engine_id = e.id " +
                    "WHERE c.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                long carId = rs.getLong(1);
                String brand = rs.getString(2);
                String model = rs.getString(3);
                int year = rs.getInt(4);
                int engineId = rs.getInt(5);
                String engineBrand = rs.getString(6);
                int power = rs.getInt(7);
                String type = rs.getString(8);
                double volume = rs.getDouble(9);
                if (engineId > 0) {
                    Engine engine = new Engine(engineId, engineBrand, power, type, volume);
                    car = new Car(carId, brand, model, year, engine);
                } else {
                    car = new Car(carId, brand, model, year);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    //update
    public static boolean update(Car car){
        return delete(car.getId()) && save(car);
    }
}
