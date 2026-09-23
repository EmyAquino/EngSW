import java.util.List;

/* ---- Product ---- */
interface Notification {
    void send(String message);
}

/* ---- ConcreteProducts ---- */
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("[Email] Enviando: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("[SMS] Enviando: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("[Push] Enviando: " + message);
    }
}

/* ---- Creator ---- */
abstract class NotificationFactory {
    // Factory Method: cada subclasse decide qual Notification concreta criar
    protected abstract Notification createNotification();

    // Metodo que USA o factory method sem conhecer a classe concreta
    public void notify(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

/* ---- ConcreteCreators ---- */
class EmailNotificationFactory extends NotificationFactory {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    protected Notification createNotification() {
        return new PushNotification();
    }
}

/* ---- Cliente ---- */
public class NotificationDemo {
    public static void main(String[] args) {
        List<NotificationFactory> factories = List.of(
            new EmailNotificationFactory(),
            new SMSNotificationFactory(),
            new PushNotificationFactory()
        );

        // O cliente conhece apenas NotificationFactory / Notification.
        // Nenhuma classe concreta (EmailNotification, SMSNotification...) aparece aqui.
        for (NotificationFactory factory : factories) {
            factory.notify("Pedido #1234 confirmado!");
        }
    }
}
