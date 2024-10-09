from abc import ABC, abstractmethod

class Airplane(ABC):
    def __init__(self, model, range, fuel, passengers_capacity):
        self._model = model
        self._range = range
        self._fuel = fuel
        self._passengers_capacity = passengers_capacity

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

class Boeing(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity):
        super().__init__(model, range, fuel, passengers_capacity)

class Embraer(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity):
        super().__init__(model, range, fuel, passengers_capacity)

class Airbus(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity):
        super().__init__(model, range, fuel, passengers_capacity)

class Airline:
    def __init__(self):
        self._fleet = []

    def add_aircraft(self, airplane):
        self._fleet.append(airplane)

    def calculate_total_capacity(self):
        total_capacity = sum(airplane.capacity for airplane in self._fleet)
        return total_capacity

    def sort_airplanes_by_range(self):
        self._fleet.sort(key=lambda airplane: airplane.range)

    def find_airplane_by_fuel_range(self, min_fuel, max_fuel):
        for airplane in self._fleet:
            if min_fuel <= airplane.fuel <= max_fuel:
                return airplane
        return None  # If no airplane is found

    @property
    def fleet(self):
        return self._fleet


def main():
    airline = Airline()

    # Додаємо літаки до компанії
    airline.add_aircraft(Boeing("Boeing 737", 5000, 8000, 160))
    airline.add_aircraft(Embraer("Embraer E190", 4000, 5000, 120))
    airline.add_aircraft(Airbus("Airbus A320", 6000, 7000, 180))

    # Підрахунок загальної місткості
    print("Загальна місткість літаку:", airline.calculate_total_capacity())

    # Сортування за дальністю польоту
    airline.sort_airplanes_by_range()
    print("Літаки після сортування за дальністю:")
    for airplane in airline.fleet:
        print(f"{airplane.model} - Дальність: {airplane.range} км")

    # Пошук літака за заданим діапазоном споживання пального
    min_fuel = 4000
    max_fuel = 9000
    found_airplane = airline.find_airplane_by_fuel_range(min_fuel, max_fuel)
    if found_airplane:
        print("Знайдено літак з споживанням пального в заданому діапазоні:", found_airplane.model)
    else:
        print("Літак зі заданим діапазоном споживання пального не знайдено.")

if __name__ == "__main__":
    main()