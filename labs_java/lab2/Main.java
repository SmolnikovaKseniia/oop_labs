public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline();

        // Додаємо літаки до компанії
        airline.addAircraft(new Boeing("Boeing 737", 5000, 8000, 160));
        airline.addAircraft(new Embraer("Embraer E190", 4000, 5000, 120));
        airline.addAircraft(new Airbus("Airbus A320", 6000, 7000, 180));

        // Підрахунок загальної місткості
        System.out.println("Загальна місткість літаку: " + airline.calculateTotalCapacity());

        // Сортування за дальністю польоту
        airline.sortAirplanesByRange();
        System.out.println("Літаки після сортування за дальністю:");
        for (Airplanes airplane : airline.getFleet()) {
            System.out.println(airplane.getModel() + " - Дальність: " + airplane.getRange() + " км");
        }

        // Пошук літака за заданим діапазоном споживання пального
        int minFuel = 4000;
        int maxFuel = 90000;
        Airplanes foundAirplane = airline.findAirplaneByFuelRange(minFuel, maxFuel);
        if (foundAirplane != null) {
            System.out.println("Знайдено літак з споживанням пального в заданому діапазоні: " + foundAirplane.getModel());
        } else {
            System.out.println("Літак зі заданим діапазоном споживання пального не знайдено.");
        }
    }
}
