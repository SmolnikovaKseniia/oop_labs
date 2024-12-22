public class ConcreteResourceHandler extends AbstractResourceHandler {
    @Override
    protected void authorize(String resourceUrl) {
        // Логіка авторизації
        if (resourceUrl == null || resourceUrl.isEmpty()) {
            throw new PermissionException("Unauthorized access to resource: " + resourceUrl);
        }
        System.out.println("Authorization successful for resource: " + resourceUrl);
    }

    @Override
    protected String fetchResource(String resourceUrl) {
        // Логіка отримання ресурсу
        if (!isResourceAvailable(resourceUrl)) {
            throw new RuntimeException("Resource not available: " + resourceUrl);
        }
        return "Resource content for " + resourceUrl;
    }

    @Override
    public boolean isResourceAvailable(String resourceName) {
        // Реальна перевірка доступності ресурсу
        return resourceName != null && !resourceName.isEmpty();
    }
}
