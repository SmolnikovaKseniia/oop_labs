public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline();

        // Додаємо літаки до компанії з вантажопідйомністю
        airline.addAircraft(new Boeing("Boeing 737", 5000, 8000, 160, 20000));  // Додаємо вантажопідйомність
        airline.addAircraft(new Embraer("Embraer E190", 4000, 5000, 120, 15000));  // Додаємо вантажопідйомність
        airline.addAircraft(new Airbus("Airbus A320", 6000, 7000, 180, 25000));  // Додаємо вантажопідйомність

        // Підрахунок загальної місткості пасажирів
        System.out.println("Загальна пасажирська місткість: " + airline.calculateTotalCapacity());

        // Підрахунок загальної вантажопідйомності
        System.out.println("Загальна вантажопідйомність: " + airline.calculateTotalCargoCapacity());

        // Сортування за дальністю польоту
        airline.sortAirplanesByRange();
        System.out.println("Літаки після сортування за дальністю:");
        for (Airplanes airplane : airline.getFleet()) {
            System.out.println(airplane.getModel() + " - Дальність: " + airplane.getRange() + " км");
        }

        // Пошук літака за заданим діапазоном споживання пального
        int minFuel = 4000;
        int maxFuel = 9000;
        Airplanes foundAirplane = airline.findAirplaneByFuelRange(minFuel, maxFuel);
        if (foundAirplane != null) {
            System.out.println("Знайдено літак з споживанням пального в заданому діапазоні: " + foundAirplane.getModel());
        }
        else {
            System.out.println("Літак зі заданим діапазоном споживання пального не знайдено.");
        }

        System.out.println("Інформація про всі літаки в авіакомпанії:");
        airline.displayFleetInfo();
    }
}
