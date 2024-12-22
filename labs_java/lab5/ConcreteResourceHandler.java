public class ConcreteResourceHandler extends AbstractResourceHandler {
    @Override
    protected void authorize(String resourceUrl) {
        // Universal access
    }

    @Override
    protected String fetchResource(String resourceUrl) {
        return "Resource content for " + resourceUrl;
    }

    @Override
    public boolean isResourceAvailable(String resourceName) {
        return false;
    }
}
