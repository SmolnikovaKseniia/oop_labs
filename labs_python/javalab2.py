from abc import ABC, abstractmethod

class Airplane(ABC):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        self._model = model
        self._range = range
        self._fuel = fuel
        self._passengers_capacity = passengers_capacity
        self._cargo_capacity = cargo_capacity  # Додано вантажопідйомність

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
        return self._cargo_capacity  # Вантажопідйомність

class Boeing(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

class Embraer(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

class Airbus(Airplane):
    def __init__(self, model, range, fuel, passengers_capacity, cargo_capacity):
        super().__init__(model, range, fuel, passengers_capacity, cargo_capacity)

class Airline:
    def __init__(self):
        self._fleet = []

    def add_aircraft(self, airplane):
        self._fleet.append(airplane)

    def calculate_total_capacity(self):
        total_capacity = sum(airplane.capacity for airplane in self._fleet)
        return total_capacity

    def calculate_total_cargo_capacity(self):  # Додано метод для підрахунку загальної вантажопідйомності
        total_cargo_capacity = sum(airplane.cargo_capacity for airplane in self._fleet)
        return total_cargo_capacity

    def sort_airplanes_by_range(self):
        self._fleet.sort(key=lambda airplane: airplane.range)

    def find_airplane_by_fuel_range(self, min_fuel, max_fuel):
        return [airplane for airplane in self._fleet if min_fuel <= airplane.fuel <= max_fuel]  # Повертає всі літаки

    @property
    def fleet(self):
        return self._fleet


def main():
    airline = Airline()

    airline.add_aircraft(Boeing("Boeing 737", 5000, 8000, 160, 20000))
    airline.add_aircraft(Embraer("Embraer E190", 4000, 5000, 120, 15000))
    airline.add_aircraft(Airbus("Airbus A320", 6000, 7000, 180, 25000))

    # Підрахунок загальної місткості
    print("Загальна пасажирська місткість літаків:", airline.calculate_total_capacity())

    # Підрахунок загальної вантажопідйомності
    print("Загальна вантажопідйомність літаків:", airline.calculate_total_cargo_capacity())

    # Сортування за дальністю польоту
    airline.sort_airplanes_by_range()
    print("Літаки після сортування за дальністю:")
    for airplane in airline.fleet:
        print(f"{airplane.model} - Дальність: {airplane.range} км")

    # Пошук літаків за заданим діапазоном споживання пального
    min_fuel = 4000
    max_fuel = 9000
    found_airplanes = airline.find_airplane_by_fuel_range(min_fuel, max_fuel)
    if found_airplanes:
        print("Знайдені літаки з споживанням пального в заданому діапазоні:")
        for found_airplane in found_airplanes:
            print(found_airplane.model)
    else:
        print("Літак зі заданим діапазоном споживання пального не знайдено.")

if __name__ == "__main__":
    main()
