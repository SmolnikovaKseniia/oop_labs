import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class Airplanes {
    private final int range;
    private final int fuel;
    private final String model;
    private final int passengersCapacity;
    private final int cargoCapacity;

    public Airplanes(String model, int range, int fuel, int passengersCapacity, int cargoCapacity) {
        this.model = model;
        this.range = range;
        this.fuel = fuel;
        this.passengersCapacity = passengersCapacity;
        this.cargoCapacity = cargoCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getRange() {
        return range;
    }

    public int getFuel() {
        return fuel;
    }

    public int getCapacity() {
        return passengersCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    // Correct placement of getAircraftInfo() inside the class
    public String getAircraftInfo() {
        return "Model: " + model + ", Range: " + range + " km, Fuel: " + fuel + " L, Passengers: " + passengersCapacity + ", Cargo: " + cargoCapacity + " kg";
    }
}

class Boeing extends Airplanes {
    public Boeing(String model, int range, int fuel, int passengersCapacity, int cargoCapacity) {
        super(model, range, fuel, passengersCapacity, cargoCapacity);
    }

    // Overriding the method to provide specific details for Boeing
    @Override
    public String getAircraftInfo() {
        return "Boeing Aircraft - " + super.getAircraftInfo();
    }
}

class Embraer extends Airplanes {
    public Embraer(String model, int range, int fuel, int passengersCapacity, int cargoCapacity) {
        super(model, range, fuel, passengersCapacity, cargoCapacity);
    }

    // Overriding the method to provide specific details for Embraer
    @Override
    public String getAircraftInfo() {
        return "Embraer Aircraft - " + super.getAircraftInfo();
    }
}

class Airbus extends Airplanes {
    public Airbus(String model, int range, int fuel, int passengersCapacity, int cargoCapacity) {
        super(model, range, fuel, passengersCapacity, cargoCapacity);
    }

    // Overriding the method to provide specific details for Airbus
    @Override
    public String getAircraftInfo() {
        return "Airbus Aircraft - " + super.getAircraftInfo();
    }
}

class Airline {
    private final List<Airplanes> fleet;

    public Airline() {
        this.fleet = new ArrayList<>();
    }

    public void addAircraft(Airplanes airplane) {
        fleet.add(airplane);
    }

    public int calculateTotalCapacity() {
        int totalCapacity = 0;
        for (Airplanes airplane : fleet) {
            totalCapacity += airplane.getCapacity();
        }
        return totalCapacity;
    }

    public int calculateTotalCargoCapacity() {
        int totalCargoCapacity = 0;
        for (Airplanes airplane : fleet) {
            totalCargoCapacity += airplane.getCargoCapacity();
        }
        return totalCargoCapacity;
    }

    public void sortAirplanesByRange() {
        fleet.sort(Comparator.comparingInt(Airplanes::getRange));
    }

    public Airplanes findAirplaneByFuelRange(int minFuel, int maxFuel) {
        for (Airplanes airplane : fleet) {
            if (airplane.getFuel() >= minFuel && airplane.getFuel() <= maxFuel) {
                return airplane;
            }
        }
        return null; // If no airplane is found
    }

    public void displayFleetInfo() {
        for (Airplanes airplane : fleet) {
            System.out.println(airplane.getAircraftInfo());
        }
    }

    public List<Airplanes> getFleet() {
        return fleet;
    }
}
