import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProxyTests {
    @Test
    void adminCanAccessResource() {
        AccessProxy proxy = new AccessProxy("admin");
        assertEquals("Resource content for example.com/resource",
                proxy.getResource("example.com/resource"));
    }

    @Test
    void guestCannotAccessResource() {
        AccessProxy proxy = new AccessProxy("guest");
        PermissionException exception = assertThrows(
                PermissionException.class,
                () -> proxy.getResource("example.com/resource")
        );
        assertEquals("Access denied for role: guest", exception.getMessage());
    }

}

