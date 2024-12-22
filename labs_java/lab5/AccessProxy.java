public class AccessProxy {
    private final String userRole;

    public AccessProxy(String userRole) {
        this.userRole = userRole;
    }

    public String getResource(String resourceUrl) {
        return "Resource content for " + resourceUrl;
    }
}
