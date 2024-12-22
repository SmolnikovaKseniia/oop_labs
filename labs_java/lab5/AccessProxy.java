import java.util.HashMap;
import java.util.Map;

public class AccessProxy {
    private final String userRole;
    private final ResourceHandler resourceHandler;
    private final Map<String, String> cache;

    public AccessProxy(String userRole) {
        this.userRole = userRole;
        this.resourceHandler = new ConcreteResourceHandler();
        this.cache = new HashMap<>();
    }

    public String getResource(String resourceUrl) {
        if (!"admin".equals(userRole)) {
            throw new PermissionException("Access denied for role: " + userRole);
        }
        return cache.computeIfAbsent(resourceUrl, resourceHandler::handleRequest);
    }
}
