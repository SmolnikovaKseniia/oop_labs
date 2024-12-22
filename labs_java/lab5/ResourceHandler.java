public interface ResourceHandler {
    /**
     * Метод для обробки запиту до ресурсу.
     *
     * @param resourceName ім'я ресурсу
     * @return результат обробки ресурсу
     * @throws Exception якщо обробка не вдалася
     */
    String handleRequest(String resourceName) throws Exception;

    /**
     * Метод для перевірки доступності ресурсу.
     *
     * @param resourceName ім'я ресурсу
     * @return true, якщо ресурс доступний, false - інакше
     */
    boolean isResourceAvailable(String resourceName);
}
