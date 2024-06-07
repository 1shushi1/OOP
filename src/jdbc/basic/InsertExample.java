package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Spilberg11")){
            String sql = "INSERT INTO CLIENT (NAME, SURNAME, PHONE, EMAIL, ADRESS, ACCOUNT) VALUES " +
                    "('Igor', 'Kauza', '8828828822', 'igor.kauza@gmail.com', 'volynska1', '1234567898765432')";
            Statement statement = connection.createStatement();
            int amountOfInsertedRows = statement.executeUpdate(sql);
            System.out.println("Amount Of Inserted Rows : " + amountOfInsertedRows);
        } catch (SQLException e){
        }
    }
}
