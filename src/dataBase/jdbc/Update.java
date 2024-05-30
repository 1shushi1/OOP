package dataBase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Spilberg11")){
            String sql = "UPDATE STAFF AS S " +
                         "SET EMAIL = 'john.dough@example.com', PHONE = '555-9874'" +
                         "WHERE S.ID = 1;";
            Statement statement = connection.createStatement();
            int num = statement.executeUpdate(sql);
            System.out.println("Amount of update rows : " + num);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
