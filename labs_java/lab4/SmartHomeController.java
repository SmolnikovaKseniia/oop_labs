public class SmartHomeController {
    private SmartHome smartHome;
    private static SmartHomeController instance;

    private SmartHomeController() {
        this.smartHome = new SmartHome();
        System.out.println("Smart Home Controller Initialized.");
    }

    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void controlLights(String house, boolean turnOn) {
        if (smartHome.isLightsOn(house) == turnOn) {
            System.out.println(turnOn
                    ? "The lights are already ON."
                    : "The lights are already OFF.");
        }
        else {
            smartHome.setLightsOn(house, turnOn);
            System.out.println(turnOn
                    ? "The lights have been turned ON."
                    : "The lights have been turned OFF.");
        }
    }

    public void controlHeating(String house, boolean turnOn) {
        if (smartHome.isHeatingOn(house) == turnOn) {
            System.out.println(turnOn
                    ? "The heating is already ON."
                    : "The heating is already OFF.");
        }
        else {
            smartHome.setHeatingOn(house, turnOn);
            System.out.println(turnOn
                    ? "The heating has been turned ON."
                    : "The heating has been turned OFF.");
        }
    }

    public void controlSecurity(String house, boolean activate) {
        if (smartHome.isSecurityOn(house) == activate) {
            System.out.println(activate
                    ? "The security system has already been ACTIVATED."
                    : "The security system has already been DEACTIVATED.");
        }
        else {
            smartHome.setSecurityOn(house, activate);
            System.out.println(activate
                    ? "The security system has been ACTIVATED."
                    : "The security system has been DEACTIVATED.");
        }
    }

    public String checkSystemStatus(String house) {
        return String.format(
                "System Status for %s:\n" +
                        "The lights are %s.\n" +
                        "The heating is %s.\n" +
                        "The security system is %s.",
                house,
                smartHome.isLightsOn(house) ? "ON" : "OFF",
                smartHome.isHeatingOn(house) ? "ON" : "OFF",
                smartHome.isSecurityOn(house) ? "ACTIVATED" : "DEACTIVATED"
        );
    }
}
