import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmartHomeControllerTest {

    private SmartHomeController smartHomeController;

    @BeforeEach
    void setUp() {
        smartHomeController = SmartHomeController.getInstance();
    }

    @Test
    void testInitialStatesAreOff() {
        String house = "house";
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The lights are OFF"), "Lights should be off by default");
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The heating is OFF"), "Heating should be off by default");
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The security system is DEACTIVATED"), "Security should be off by default");
    }

    @Test
    void testControlLights() {
        String house = "house";

        smartHomeController.controlLights(house, true);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The lights are ON"), "Lights should be on after turning on");

        smartHomeController.controlLights(house, false);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The lights are OFF"), "Lights should be off after turning off");
    }

    @Test
    void testControlHeating() {
        String house = "house";

        smartHomeController.controlHeating(house, true);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The heating is ON"), "Heating should be on after turning on");

        smartHomeController.controlHeating(house, false);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The heating is OFF"), "Heating should be off after turning off");
    }

    @Test
    void testControlSecurity() {
        String house = "house";

        smartHomeController.controlSecurity(house, true);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The security system is ACTIVATED"), "Security should be activated after turning on");

        smartHomeController.controlSecurity(house, false);
        assertTrue(smartHomeController.checkSystemStatus(house).contains("The security system is DEACTIVATED"), "Security should be deactivated after turning off");
    }

    @Test
    void testSingletonInstance() {
        SmartHomeController anotherInstance = SmartHomeController.getInstance();
        assertSame(smartHomeController, anotherInstance, "SmartHomeController should be a singleton");
    }
}
