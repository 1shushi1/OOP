package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Spilberg11")){
            String sql = "UPDATE CLIENT AS C " +
                         "SET PHONE = '982734982374', EMAIL = 'HAVCHYK1@GMAIL.COM' " +
                         "WHERE C.ID = 1";

            Statement statement = connection.createStatement();
            int amountOfUpdatedRows = statement.executeUpdate(sql);
            System.out.println("Amount Of Updated Rows : " + amountOfUpdatedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
