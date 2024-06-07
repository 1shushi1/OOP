package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Spilberg11")) {
            String sql = "DELETE FROM CLIENT AS C " +
                         "WHERE C.ID = 29";
            Statement statement = connection.createStatement();
            int amountOfDeletedRows = statement.executeUpdate(sql);
            System.out.println("Amount of deleted rows : " + amountOfDeletedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
