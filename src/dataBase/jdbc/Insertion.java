package dataBase.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertion {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Spilberg11")){
            String sql = "INSERT INTO STAFF (NAME, SURNAME, POSITION, ADDRESS, PHONE, EMAIL, DATE_OF_BIRTH, SALARY, CV) VALUES " +
                    "('Lucas', 'White', 'Product Manager', '1818 Maple St, Springfield, IL', '555-6789', 'lucas.white@example.com', '1989-04-11', 70000.00, 'Product manager with a proven track record in product development.'), " +
                    "('Harper', 'Adams', 'Content Writer', '1919 Birch St, Springfield, IL', '555-2345', 'harper.adams@example.com', '1993-09-17', 48000.00, 'Creative content writer with experience in various industries.'), " +
                    "('Liam', 'Perez', 'Network Engineer', '2020 Cedar St, Springfield, IL', '555-8765', 'liam.perez@example.com', '1987-12-29', 68000.00, 'Experienced network engineer specializing in network infrastructure.');";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            int num = statement.executeUpdate(sql);
            System.out.println("Amount of inserted rows " + num);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
