package dataBase.orm.one2one;

import java.sql.*;

public class CarDAO implements Dao {
    private Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Car save(Entity entity) {
        Car car = (Car) entity;
        String sqlCar = "insert into cars (brand, model, year, engine_id) values (?,?,?,?)";
        String sqlEngine = "insert into engines (brand, power, type, volume) values (?, ?, ?, ?)";
        String sqlGear = "insert into gearboxes (type, speed, brand) values (?,?,?)";
        String sqlCarsGears = "insert into cars_gears (car_id, gear_id) values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlEngine, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement preparedStatement1 = connection.prepareStatement(sqlGear, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement preparedStatement2 = connection.prepareStatement(sqlCar, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement preparedStatement3 = connection.prepareStatement(sqlCarsGears, PreparedStatement.RETURN_GENERATED_KEYS)) {
            if (car.getEngine() != null) {
                preparedStatement.setString(1, car.getEngine().getBrand());
                preparedStatement.setInt(2, car.getEngine().getPower());
                preparedStatement.setString(3, car.getEngine().getType());
                preparedStatement.setDouble(4, car.getEngine().getPower());
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    car.getEngine().setId(id);
                }
            }
            if (car.getTransmission() != null) {
                preparedStatement1.setString(1, car.getTransmission().getType());
                preparedStatement1.setInt(2, car.getTransmission().getAmountOfSpeeds());
                preparedStatement1.setString(3, car.getTransmission().getBrand());
                preparedStatement1.executeUpdate();
                ResultSet rs = preparedStatement1.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    car.getTransmission().setId(id);
                }
            }
            if (car.getEngine() != null) {
                preparedStatement2.setInt(4, (int) car.getEngine().getId());
            } else {
                preparedStatement2.setNull(4, Types.INTEGER);
            }
            preparedStatement2.setString(1, car.getBrand());
            preparedStatement2.setString(2, car.getModel());
            preparedStatement2.setInt(3, car.getYear());
            preparedStatement2.executeUpdate();
            ResultSet rs = preparedStatement2.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                car.setId(id);
            }
            if (car.getTransmission() != null) {
                preparedStatement3.setInt(1, (int) car.getId());
                preparedStatement3.setInt(2, (int) car.getTransmission().getId());
                preparedStatement3.executeUpdate();
            }
            connection.commit();
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Car delete(Entity entity) {
        Car car = (Car) entity;
        String sqlCar = "delete from cars as c where c.id = ?";
        String sqlEngine = "delete from engines as e where e.id = ?";
        String sqlGearbox = "delete from gearboxes as g where g.id = ?";
        try (PreparedStatement carDel = connection.prepareStatement(sqlCar);
             PreparedStatement engineDel = connection.prepareStatement(sqlEngine);
             PreparedStatement gearboxesDel = connection.prepareStatement(sqlGearbox)) {
            carDel.setInt(1, (int) car.getId());
            if (carDel.executeUpdate() == 0) {
                throw new SQLException("car del error");
            }
            if (car.getEngine() != null) {
                engineDel.setInt(1, (int) car.getEngine().getId());
                if (engineDel.executeUpdate() == 0) {
                    throw new SQLException("engine del error");
                }
            }
            if (car.getTransmission() != null) {
                gearboxesDel.setInt(1, (int) car.getTransmission().getId());
                if (gearboxesDel.executeUpdate() == 0) {
                    throw new SQLException("gearbox del error");
                }
            }
            connection.commit();
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Car update(Entity entity) {
        Car car = (Car) entity;
        String sqlCar = "delete from cars as c where c.id = ?";
        String sqlEngine = "delete from engines as e where e.id = ?";
        String sqlGearbox = "delete from gearboxes as g where g.id = ?";
        String sqlCarSave = "insert into cars (brand, model, year, engine_id) values (?,?,?,?)";
        String sqlEngineSave = "insert into engines (brand, power, type, volume) values (?, ?, ?, ?)";
        String sqlGearSave = "insert into gearboxes (type, speed, brand) values (?,?,?)";
        String sqlCarsGearsSave = "insert into cars_gears (car_id, gear_id) values (?, ?)";
        try (PreparedStatement carDel = connection.prepareStatement(sqlCar);
             PreparedStatement engineDel = connection.prepareStatement(sqlEngine);
             PreparedStatement gearboxesDel = connection.prepareStatement(sqlGearbox);
             PreparedStatement carSaveEngine = connection.prepareStatement(sqlEngineSave, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement carSaveGearbox = connection.prepareStatement(sqlGearSave, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement saveCar = connection.prepareStatement(sqlCarSave, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement saveCarGears = connection.prepareStatement(sqlCarsGearsSave, PreparedStatement.RETURN_GENERATED_KEYS)) {
            carDel.setInt(1, (int) car.getId());
            if (carDel.executeUpdate() == 0) {
                throw new SQLException("car del error");
            }
            if (car.getEngine() != null) {
                engineDel.setInt(1, (int) car.getEngine().getId());
                if (engineDel.executeUpdate() == 0) {
                    throw new SQLException("engine del error");
                }
            }
            if (car.getTransmission() != null) {
                gearboxesDel.setInt(1, (int) car.getTransmission().getId());
                if (gearboxesDel.executeUpdate() == 0) {
                    throw new SQLException("gearbox del error");
                }
            }
            if (car.getEngine() != null) {
                carSaveEngine.setString(1, car.getEngine().getBrand());
                carSaveEngine.setInt(2, car.getEngine().getPower());
                carSaveEngine.setString(3, car.getEngine().getType());
                carSaveEngine.setDouble(4, car.getEngine().getPower());
                carSaveEngine.executeUpdate();
                ResultSet rs = carSaveEngine.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    car.getEngine().setId(id);
                }
            }
            if (car.getTransmission() != null) {
                carSaveGearbox.setString(1, car.getTransmission().getType());
                carSaveGearbox.setInt(2, car.getTransmission().getAmountOfSpeeds());
                carSaveGearbox.setString(3, car.getTransmission().getBrand());
                carSaveGearbox.executeUpdate();
                ResultSet rs = carSaveGearbox.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    car.getTransmission().setId(id);
                }
            }
            if (car.getEngine() != null) {
                saveCar.setInt(4, (int) car.getEngine().getId());
            } else {
                saveCar.setNull(4, Types.INTEGER);
            }
            saveCar.setString(1, car.getBrand());
            saveCar.setString(2, car.getModel());
            saveCar.setInt(3, car.getYear());
            saveCar.executeUpdate();
            ResultSet rs = saveCar.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                car.setId(id);
            }
            if (car.getTransmission() != null) {
                saveCarGears.setInt(1, (int) car.getId());
                saveCarGears.setInt(2, (int) car.getTransmission().getId());
                saveCarGears.executeUpdate();
            }
            connection.commit();
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Car find(Object id) {
        String carSQL = "select c.id as car_id, c.brand, c.model, c.year, e.id as engine_id, e.brand, e.power, e.type, e.volume, g.id as gearboxes_id, g.type, g.speed, g.brand from cars as c " +
                "left join engines as e on c.engine_id = e.id " +
                "left join cars_gears as cg on cg.car_id = c.id " +
                "left join gearboxes as g on cg.gear_id = g.id " +
                "where c.id = ?";
        try (PreparedStatement carFinder = connection.prepareStatement(carSQL)) {
            carFinder.setInt(1, (int) id);
            ResultSet rs = carFinder.executeQuery();
            if (rs.next()) {
                connection.commit();
                return new Car((int) id, rs.getString(2), rs.getString(3), rs.getInt(4),
                        new Engine(rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getDouble(9)),
                        new Transmission(rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }
}
