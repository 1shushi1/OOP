package dataBase.orm.one2one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //--------------------save controller--------------------
//        Engine engine1 = new Engine(11, "Volkswagen", "V2", 189, 2.0);
//        Car car = new Car(16, "Volkswagen", "Golf", 2023);
//        boolean save = CarController.save(car);
//        if (save){
//            System.out.println("Car saved");
//        } else {
//            System.out.println("Fail");
//        }
        //--------------------delete controller--------------------
//        boolean delete = CarController.delete(11);
//        if (delete){
//            System.out.println("Car was successfully deleted");
//        } else {
//            System.out.println("Fail");
//        }
        //--------------------find controller--------------------
//        Car car = CarController.find(3);
//        System.out.println(car);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11")){
            EngineDAO engineDAO = new EngineDAO(connection);
            Engine engine1 = new Engine(11l, "Volkswagen", 189, "V2", 2.0);
            //save
//            Entity savedEngine = engineDAO.save(engine1);
//            System.out.println(savedEngine);
            //delete
//            Engine engine = engineDAO.delete(engine1);
//            System.out.println(engine);
            //find
//            Engine engine = engineDAO.find(3l);
//            System.out.println(engine);
            //update
//            Entity entity = engineDAO.update();


        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
