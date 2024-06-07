package jdbc.basic;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class SelectExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Driver driver = new Driver();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Spilberg11");
            DatabaseMetaData dbMeta = connection.getMetaData();
            String user = dbMeta.getUserName();
            System.out.println("Username : " + user);
            String sql = "SELECT * FROM CLIENT;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int amountOfColumns = rsmd.getColumnCount();
            for (int i = 1; i <= amountOfColumns; i++) {
                System.out.print(rsmd.getColumnName(i) + "   ");
            }
            System.out.println();
            while (rs.next()){
                Long longID = rs.getLong(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                String adress = rs.getString(6);
                String account = rs.getString(7);
                System.out.println(longID + "   " + name + "   " + surname + "   " + phone + "   " + email + "   " + adress + "   " + account);
            }
        } catch (SQLException e){
        } finally {
            try {
                connection.close();
            } catch (SQLException e){
            }
        }
    }
}
