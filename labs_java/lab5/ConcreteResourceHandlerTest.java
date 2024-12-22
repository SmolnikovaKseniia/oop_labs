import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteResourceHandlerTest {

    @Test
    void testSuccessfulRequest() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "http://example.com/resource";
        assertTrue(handler.isResourceAvailable(resourceUrl));
        String result = handler.handleRequest(resourceUrl);

        assertEquals("Resource content for http://example.com/resource", result);
    }

    @Test
    void testUnauthorizedRequest() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = "";
        assertFalse(handler.isResourceAvailable(resourceUrl));
        assertThrows(PermissionException.class, () -> handler.handleRequest(resourceUrl));
    }

    @Test
    void testUnavailableResource() {
        ResourceHandler handler = new ConcreteResourceHandler();

        String resourceUrl = null;
        assertThrows(RuntimeException.class, () -> handler.handleRequest(resourceUrl));
    }
}
