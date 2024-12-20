import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmartHomeTest {

    private SmartHome smartHome;

    @BeforeEach
    void setUp() {
        smartHome = new SmartHome();
    }

    @Test
    void testInitialStatesAreOff() {
        assertFalse(smartHome.isLightsOn("house"), "Lights should be off by default");
        assertFalse(smartHome.isHeatingOn("house"), "Heating should be off by default");
        assertFalse(smartHome.isSecurityOn("house"), "Security should be off by default");
    }

    @Test
    void testSetAndGetLightsOn() {
        smartHome.setLightsOn("house", true);
        assertTrue(smartHome.isLightsOn("house"), "Lights should be on after setting to true");

        smartHome.setLightsOn("house", false);
        assertFalse(smartHome.isLightsOn("house"), "Lights should be off after setting to false");
    }

    @Test
    void testSetAndGetHeatingOn() {
        smartHome.setHeatingOn("house", true);
        assertTrue(smartHome.isHeatingOn("house"), "Heating should be on after setting to true");

        smartHome.setHeatingOn("house", false);
        assertFalse(smartHome.isHeatingOn("house"), "Heating should be off after setting to false");
    }

    @Test
    void testSetAndGetSecurityOn() {
        smartHome.setSecurityOn("house", true);
        assertTrue(smartHome.isSecurityOn("house"), "Security should be on after setting to true");

        smartHome.setSecurityOn("house", false);
        assertFalse(smartHome.isSecurityOn("house"), "Security should be off after setting to false");
    }
}
