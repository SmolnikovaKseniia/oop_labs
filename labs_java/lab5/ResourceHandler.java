public interface ResourceHandler {
    String handleRequest(String resourceName);

    boolean isResourceAvailable(String resourceName);
}
