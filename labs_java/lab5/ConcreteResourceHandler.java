public class ConcreteResourceHandler extends AbstractResourceHandler {

    @Override
    protected void authorize(String resourceUrl) {
        if (resourceUrl == null || resourceUrl.isEmpty()) {
            throw new PermissionException("Unauthorized access to resource: " + resourceUrl);
        }
        System.out.println("Authorization successful for resource: " + resourceUrl);
    }

    @Override
    protected String fetchResource(String resourceUrl) {
        if (!isResourceAvailable(resourceUrl)) {
            throw new RuntimeException("Resource not available: " + resourceUrl);
        }
        return "Resource content for " + resourceUrl;
    }

    @Override
    public boolean isResourceAvailable(String resourceName) {
        // Simulating availability logic (only valid URLs containing "resource" are available)
        return resourceName != null && resourceName.contains("resource");
    }
}
