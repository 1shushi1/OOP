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
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/one2one", "root", "Spilberg11")){
//            EngineDAO engineDAO = new EngineDAO(connection);

            //save
//            Entity savedEngine = engineDAO.save(engine1);
//            System.out.println(savedEngine);
            //delete
//            Engine engine = engineDAO.delete(engine1);
//            System.out.println(engine);
            //find
//            Engine engine = engineDAO.find(12l);
//            System.out.println(engine);
            //update
//            Entity entity = engineDAO.update(engine1);
//            System.out.println(entity);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }

        //engine checker
//        Engine engine = new Engine(11l, "Volkswagen", 200, "V2", 3.0);
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
//        EngineDAO engineDAO1 = (EngineDAO) daoFactory.getDao("engine");
//        Entity entity = engineDAO1.save(engine);
//        System.out.println(entity);

        //transmission checker
//        Transmission tr = new Transmission(8l, "Automatic", 6, "Mercedes");
//        TransmissionDAO transmissionDAO = (TransmissionDAO) daoFactory.getDao("transmission");
        //save
//        Transmission save = transmissionDAO.save(tr);
//        System.out.println(save);
        //delete
//        Transmission delete = transmissionDAO.delete(tr);
//        System.out.println(delete);
        //update
//        Transmission update = transmissionDAO.update(tr);
//        System.out.println(update);
        //find
//        Transmission find = transmissionDAO.find(10l);
//        System.out.println(find);


        //car checker
        CarDAO carDAO = (CarDAO) daoFactory.getDao("car");
        //first car - it has everything
        Engine engine1 = new Engine(81, "Ford", 450, "V8", 5.0);
        Transmission transmission1 = new Transmission(29, "Automatic", 6, "Ford");
        Car fullyComplected = new Car(31, "Ford", "F-150", 2023, engine1, transmission1);

        //second car - car with transmission but no engine
        Transmission transmission2 = new Transmission(30, "Automatic", 5, "Honda");
        Car carWithNoEngine = new Car(32, "Honda", "Civic", 2023, null, transmission2);

        //third car - car with engine but no transmission
        Engine engine3 = new Engine(82, "Toyota", 139, "Inline-4", 1.8);
        Car carWithNoGear = new Car(33, "Toyota", "RAV4", 2023, engine3, null);

        //save car
//        Car car1 = carDAO.save(fullyComplected);
//        Car car2 = carDAO.save(carWithNoEngine);
//        Car car3 = carDAO.save(carWithNoGear);
//
//        System.out.println("Car that has everything : " + car1);
//        System.out.println("Car with transmission but no engine : " + car2);
//        System.out.println("Car with engine but no transmission : " + car3);

        //delete cars
//        Car car1 = carDAO.delete(fullyComplected);
//        Car car2 = carDAO.delete(carWithNoEngine);
//        Car car3 = carDAO.delete(carWithNoGear);
//
//        System.out.println(car1);
//        System.out.println(car2);
//        System.out.println(car3);

        //udpate cars
//        Car car1 = carDAO.update(fullyComplected);
//        Car car2 = carDAO.update(carWithNoEngine);
//        Car car3 = carDAO.update(carWithNoGear);
//
//        System.out.println(car1);
//        System.out.println(car2);
//        System.out.println(car3);

        //find car
//        Car car1 = carDAO.find(2);
//        Car car2 = carDAO.find(4);
//        Car car3 = carDAO.find(5);
//
//        System.out.println("Car 2 : " + car1);
//        System.out.println("Car 4 : " + car2);
//        System.out.println("Car 5 : " + car3);
    }
}
