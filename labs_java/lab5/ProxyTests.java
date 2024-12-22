import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessProxySpec {
    @Test
    void adminCanAccessResource() {
        AccessProxy proxy = new AccessProxy("admin");
        assertEquals("Resource content for example.com/resource",
                proxy.getResource("example.com/resource"));
    }
}
