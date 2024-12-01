import java.util.Scanner;

public class SmartHomeUI {
    public static void main(String[] args) {
        SmartHomeController controller = SmartHomeController.getInstance();
        Scanner scanner = new Scanner(System.in);

        String house = "MyHouse"; // Назва будинку
        boolean exit = false;

        System.out.println("Welcome to Smart Home System!");
        while (!exit) {
            System.out.println("\n +++ Smart Home Menu +++");
            System.out.println("1. Control Lights");
            System.out.println("2. Control Heating");
            System.out.println("3. Control Security");
            System.out.println("4. Check System Status");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Turn ON Lights");
                    System.out.println("2. Turn OFF Lights");
                    System.out.print("Choose an option: ");
                    int lightChoice = scanner.nextInt();
                    controller.controlLights(house, lightChoice == 1);
                    break;

                case 2:
                    System.out.println("1. Turn ON Heating");
                    System.out.println("2. Turn OFF Heating");
                    System.out.print("Choose an option: ");
                    int heatingChoice = scanner.nextInt();
                    controller.controlHeating(house, heatingChoice == 1);
                    break;

                case 3:
                    System.out.println("1. Activate Security");
                    System.out.println("2. Deactivate Security");
                    System.out.print("Choose an option: ");
                    int securityChoice = scanner.nextInt();
                    controller.controlSecurity(house, securityChoice == 1);
                    break;

                case 4:
                    System.out.println(controller.checkSystemStatus(house));
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting Smart Home System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
