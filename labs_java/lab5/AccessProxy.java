public class AccessProxy {
    private final String userRole;

    public AccessProxy(String userRole) {
        this.userRole = userRole;
    }

    public String getResource(String resourceUrl) {
        if (!"admin".equals(userRole)) {
            throw new PermissionException("Access denied for role: " + userRole);
        }
        return "Resource content for " + resourceUrl;
    }
}
