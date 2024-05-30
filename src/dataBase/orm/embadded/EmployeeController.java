package dataBase.orm.embadded;

import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

public class EmployeeController {

    //save employee
    public static boolean save(Employee employee) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orm", "root", "Spilberg11")) {
            long id = employee.getId().getId();
            String department = employee.getId().getDepartment();
            String name = employee.getName();
            String surname = employee.getSurname();
            Gender gender = employee.getGender();
            double salary = employee.getSalary();
            StringBuilder employeeData = new StringBuilder();
            employeeData.append("(" + id + ", ");
            employeeData.append("'" + department + "'" + ", ");
            employeeData.append("'" + name + "'" + ", ");
            employeeData.append("'" + surname + "'" + ", ");
            employeeData.append("'" + gender + "'" + ", ");
            employeeData.append(salary + ")");
            String sql = "INSERT INTO EMPLOYEE (ID, DEPARTMENT, NAME, SURNAME, GENDER, SALARY) VALUES " +
                    employeeData;
            List<String> phones = employee.getPhones();
            List<String> phoneQueries = new ArrayList<>();
            if (employee.getPhones() != null) {
                StringBuilder empPhone = new StringBuilder();
                for (int i = 0; i < phones.size(); i++) {
                    empPhone.append("(" + id + ", ");
                    empPhone.append("'" + department + "'" + ", ");
                    empPhone.append("'" + phones.get(i) + "')");
                    phoneQueries.add("INSERT INTO PHONE (STAFF_ID, DEPARTMENT, PHONE) VALUES " +
                            empPhone);
                    empPhone = new StringBuilder();
                }
            }
//            phoneQueries.forEach(e -> System.out.println(e));
            List<String> skillQueries = new ArrayList<>();
            List<Skill> skills = employee.getSkills();
            if (employee.getSkills() != null) {
                StringBuilder empSkills =  new StringBuilder();
                for (int i = 0; i < skills.size(); i++) {
                    empSkills.append("(" + id + ", ");
                    empSkills.append("'" + department + "', ");
                    empSkills.append("'" + skills.get(i).getTitle() + "', ");
                    empSkills.append(skills.get(i).getExperience() + ")");
                    skillQueries.add("INSERT INTO SKILL (STAFF_ID, DEPARTMENT, TITLE, EXPERIENCE) VALUES " +
                            empSkills);
                    empSkills = new StringBuilder();
                }
            }
//            skillQueries.forEach(e -> System.out.println(e));
            Statement statement = connection.createStatement();
            int num = statement.executeUpdate(sql);
            int numOfInsertedPhones = 0;
            for (int i = 0; i < phoneQueries.size(); i++) {
                numOfInsertedPhones += statement.executeUpdate(phoneQueries.get(i));
            }
            System.out.println("Number of uploaded phones : " + numOfInsertedPhones);
            int numOfInsertedSkills = 0;
            for (int i = 0; i < skillQueries.size(); i++) {
                numOfInsertedSkills += statement.executeUpdate(skillQueries.get(i));
            }
            System.out.println("Number of uploaded skills : " + numOfInsertedSkills);
            if (num > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //find employee by id
    public static void find(StaffID staffID){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orm", "root", "Spilberg11")){
            long id = staffID.getId();
            String department = staffID.getDepartment();
            StringBuilder sb = new StringBuilder();
            sb.append("WHERE E.ID = " + id + " AND E.DEPARTMENT = '" + department + "'");
            String sql = "SELECT E.ID, E.DEPARTMENT, E.NAME, E.SURNAME, E.GENDER, E.SALARY, P.PHONE, S.TITLE, S.EXPERIENCE FROM EMPLOYEE AS E " +
                    "LEFT JOIN PHONE AS P ON E.ID = P.STAFF_ID AND E.DEPARTMENT = P.DEPARTMENT " +
                    "LEFT JOIN SKILL AS S ON E.ID = S.STAFF_ID AND E.DEPARTMENT = S.DEPARTMENT " +
                    sb;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Skill> skills = new ArrayList<>();
            List<String> phones = new ArrayList<>();
            String empPhones = "";
            while(rs.next()) {
                long empID = rs.getInt(1);
                String empDepartment = rs.getString(2);
                String name = rs.getString(3);
                String surname = rs.getString(4);
                Gender empGender = Gender.valueOf(rs.getString(5));
                double empSalary = rs.getDouble(6);
                empPhones = rs.getString(7);
//                System.out.println(empPhones);
                if (empPhones != null) {
                    String[] lines = empPhones.split("\n");
                    Set<String> uniquePhones = new HashSet<>(Arrays.asList(lines));

                    // Print or use unique phone numbers
                    for (String phone : uniquePhones) {
                        System.out.println(phone);
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
