from abc import ABC, abstractmethod

class Airplane(ABC):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        self._model = model
        self._range = range
        self._fuel = fuel
        self._passengers_capacity = passengers_capacity
        self._cargo_capacity = cargo_capacity  # Added cargo capacity

    @property
    def model(self):
        return self._model

    @property
    def range(self):
        return self._range

    @property
    def fuel(self):
        return self._fuel

    @property
    def capacity(self):
        return self._passengers_capacity

    @property
    def cargo_capacity(self):
        return self._cargo_capacity  # Cargo capacity

    # Polymorphic method
    @abstractmethod
    def get_aircraft_info(self):
        pass


class Boeing(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

    # Overriding get_aircraft_info to provide Boeing-specific information
    def get_aircraft_info(self):
        return f"Boeing Aircraft: {self.model}, Range: {self.range} km, Fuel: {self.fuel} L, Passengers: {self.capacity}, Cargo: {self.cargo_capacity} kg"


class Embraer(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

    # Overriding get_aircraft_info to provide Embraer-specific information
    def get_aircraft_info(self):
        return f"Embraer Aircraft: {self.model}, Range: {self.range} km, Fuel: {self.fuel} L, Passengers: {self.capacity}, Cargo: {self.cargo_capacity} kg"


class Airbus(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

    # Overriding get_aircraft_info to provide Airbus-specific information
    def get_aircraft_info(self):
        return f"Airbus Aircraft: {self.model}, Range: {self.range} km, Fuel: {self.fuel} L, Passengers: {self.capacity}, Cargo: {self.cargo_capacity} kg"


class Airline:
    def __init__(self):
        self._fleet = []

    def add_aircraft(self, airplane):
        self._fleet.append(airplane)

    def calculate_total_capacity(self):
        total_capacity = sum(airplane.capacity for airplane in self._fleet)
        return total_capacity

    def calculate_total_cargo_capacity(self):
        total_cargo_capacity = sum(airplane.cargo_capacity for airplane in self._fleet)
        return total_cargo_capacity

    def sort_airplanes_by_range(self):
        self._fleet.sort(key=lambda airplane: airplane.range)

    def find_airplanes_by_fuel_range(self, min_fuel, max_fuel):
        return [airplane for airplane in self._fleet if min_fuel <= airplane.fuel <= max_fuel]

    @property
    def fleet(self):
        return self._fleet

    # Displaying all aircraft information (polymorphic behavior)
    def display_fleet_info(self):
        for airplane in self._fleet:
            print(airplane.get_aircraft_info())


def main():
    airline = Airline()

    # Adding aircrafts to the fleet
    airline.add_aircraft(Boeing("Boeing 737", 5000, 8000, 160, 20000))
    airline.add_aircraft(Embraer("Embraer E190", 4000, 5000, 120, 15000))
    airline.add_aircraft(Airbus("Airbus A320", 6000, 7000, 180, 25000))

    # Total passenger capacity
    print("Total passenger capacity of the fleet:", airline.calculate_total_capacity())

    # Total cargo capacity
    print("Total cargo capacity of the fleet:", airline.calculate_total_cargo_capacity())

    # Sorting airplanes by range
    airline.sort_airplanes_by_range()
    print("Airplanes sorted by range:")
    airline.display_fleet_info()

    # Finding airplanes by fuel range
    min_fuel = 4000
    max_fuel = 9000
    found_airplanes = airline.find_airplanes_by_fuel_range(min_fuel, max_fuel)
    if found_airplanes:
        print("Airplanes found within the fuel consumption range:")
        for airplane in found_airplanes:
            print(airplane.get_aircraft_info())
    else:
        print("No airplanes found within the specified fuel range.")


if __name__ == "__main__":
    main()
