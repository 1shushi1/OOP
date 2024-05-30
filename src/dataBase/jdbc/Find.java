package dataBase.jdbc;

import java.sql.*;

public class Find {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Spilberg11")){
            String sql = "SELECT S.ID, S.NAME, S.SURNAME, S.POSITION, S.ADDRESS, S.PHONE, S.EMAIL, S.DATE_OF_BIRTH, S.SALARY, S.CV, S.PHOTO, ROUND(DATEDIFF(NOW(), S.DATE_OF_BIRTH)/365) AS AGE " +
                         "FROM STAFF AS S " +
                         "WHERE DATEDIFF(NOW(), S.DATE_OF_BIRTH) BETWEEN 365*20 AND 365*30;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.print("ID   " + "Name   " + "Surname   " + "Position   " + "Phone   " + "Address   " + "Email   " + "DOB   " + "Salary   " + "CV   " + "Age");
            System.out.println();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String surname = rs.getString(3);
                String pos = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                Date date = rs.getDate(8);
                double salary = rs.getDouble(9);
                String cv = rs.getString(10);
                Blob photo = rs.getBlob(11);
                int age = rs.getInt(12);
                System.out.println(id + "   " + name + "   " + surname + "   " +  pos + "   " +  phone + "   " + address + "   " +  email + "   " +  date + "   " + salary + "   " + cv + "   " + age);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
