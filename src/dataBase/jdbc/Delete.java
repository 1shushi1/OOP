package dataBase.jdbc;

import java.sql.*;

public class Delete {
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Spilberg11")) {
            String sql = "DELETE FROM STAFF AS S " +
                         "WHERE S.ID = 23;";
            Statement statement = connection.createStatement();
            int num = statement.executeUpdate(sql);
            System.out.println("Deleted rows : " + num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
