import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConcreteHandlerTest {

    @Test
    void testSuccessfulRequest() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "http://example.com/resource";
        assertTrue(handler.isResourceAvailable(resourceUrl));

        String result = handler.handleRequest(resourceUrl);
        assertEquals("Resource content for http://example.com/resource", result);
    }

    @Test
    void testEmptyResourceAuthorization() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "";
        assertFalse(handler.isResourceAvailable(resourceUrl));
        assertThrows(PermissionException.class, () -> handler.handleRequest(resourceUrl));
    }

    @Test
    void testNullResourceAuthorization() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = null;
        assertFalse(handler.isResourceAvailable(resourceUrl));
        assertThrows(PermissionException.class, () -> handler.handleRequest(resourceUrl));
    }

    @Test
    void testUnavailableResource() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "http://example.com/unavailable";
        assertFalse(handler.isResourceAvailable(resourceUrl));
        assertThrows(RuntimeException.class, () -> handler.handleRequest(resourceUrl));
    }

    @Test
    void testSuccessfulLogging() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "http://example.com/resource";

        // Capture system output to ensure logging is correct
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        handler.handleRequest(resourceUrl);

        // Validate log output
        String expectedLog = "Accessing resource: http://example.com/resource";
        assertTrue(outContent.toString().contains(expectedLog));
    }
}
