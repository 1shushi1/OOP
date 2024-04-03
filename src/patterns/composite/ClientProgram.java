package patterns.composite;

public class ClientProgram {
    public static void main(String[] args) {
        Task carCreation = new CompositeTask("Car Production");
        Task createEngine = new CompositeTask("Engine Creation");
        Task pidgotovkaPorshnevoiGrupy = new SimpleTask("Dobavlennya porshniv do dvugyna");
        Task candleInsertion = new SimpleTask("Candle insertion to the engine");
        Task fillOil = new SimpleTask("Fill engine with oil");

        ((CompositeTask) createEngine).addTask(pidgotovkaPorshnevoiGrupy);
        ((CompositeTask) createEngine).addTask(candleInsertion);
        ((CompositeTask) createEngine).addTask(fillOil);

        Task transmissionCreation = new CompositeTask("Transmission creation");
        Task addGear = new SimpleTask("Add gear");
        Task addCase = new SimpleTask("Add case");
        Task addShaft = new SimpleTask("Add shafts");
        Task addClutch = new SimpleTask("Add clutch");
        Task addControlModule = new SimpleTask("Add control module");
        ((CompositeTask) transmissionCreation).addTask(addGear);
        ((CompositeTask) transmissionCreation).addTask(addCase);
        ((CompositeTask) transmissionCreation).addTask(addShaft);
        ((CompositeTask) transmissionCreation).addTask(addClutch);
        ((CompositeTask) transmissionCreation).addTask(addControlModule);

        Task addWheels = new SimpleTask("Add wheels");
        Task addWindows = new SimpleTask("Add windows");
        Task addDoors = new SimpleTask("Add doors");
        Task bodyCreation = new CompositeTask("Body creation");

        Task interiorPreparation = new CompositeTask("Prepare interior");
        Task addSeats = new SimpleTask("Add seats");
        Task addSteeringWheel = new SimpleTask("Add Steering Wheel");
        Task addButtons = new SimpleTask("Add buttons");
        ((CompositeTask) interiorPreparation).addTask(addSeats);
        ((CompositeTask) interiorPreparation).addTask(addSteeringWheel);
        ((CompositeTask) interiorPreparation).addTask(addButtons);

        ((CompositeTask) bodyCreation).addTask(interiorPreparation);
        ((CompositeTask) bodyCreation).addTask(addWheels);
        ((CompositeTask) bodyCreation).addTask(addDoors);
        ((CompositeTask) bodyCreation).addTask(addWindows);

        ((CompositeTask) carCreation).addTask(bodyCreation);
        ((CompositeTask) carCreation).addTask(createEngine);
        ((CompositeTask) carCreation).addTask(transmissionCreation);

        carCreation.display();
    }
}

