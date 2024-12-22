public abstract class AbstractResourceHandler implements ResourceHandler {
    @Override
    public final String handleRequest(String resourceUrl) {
        logRequest(resourceUrl);
        authorize(resourceUrl);
        return fetchResource(resourceUrl);
    }

    protected abstract void authorize(String resourceUrl);

    protected abstract String fetchResource(String resourceUrl);

    private void logRequest(String resourceUrl) {
        System.out.println("Accessing resource: " + resourceUrl);
    }
}
