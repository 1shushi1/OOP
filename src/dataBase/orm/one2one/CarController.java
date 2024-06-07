package dataBase.orm.one2one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void find(Object id){

    }

    //update
    public static boolean update(Car car){
        return delete(car.getId()) && save(car);
    }
}
