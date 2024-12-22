public class Demo {
    public static void main(String[] args) {
        // Створення проксі для користувача з роллю "admin"
        AccessProxy adminProxy = new AccessProxy("admin");
        String resourceUrl = "admin/resource";

        // Доступ до ресурсу для адміністратора
        try {
            System.out.println("Admin access: " + adminProxy.getResource(resourceUrl));
        }
        catch (PermissionException e) {
            System.out.println(e.getMessage());
        }

        // Створення проксі для користувача з роллю "user"
        AccessProxy userProxy = new AccessProxy("user");

        // Доступ до ресурсу для звичайного користувача (заборонено)
        try {
            System.out.println("User access: " + userProxy.getResource(resourceUrl));
        }
        catch (PermissionException e) {
            System.out.println(e.getMessage());  // Виведе: Access denied for role: user
        }

        // Перевірка кешування: повторний запит до того ж ресурсу
        try {
            System.out.println("Cached admin access: " + adminProxy.getResource(resourceUrl));
        }
        catch (PermissionException e) {
            System.out.println(e.getMessage());
        }
    }
}