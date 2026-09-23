// ---- Product ----
trait Notification {
    fn send(&self, message: &str);
}

// ---- ConcreteProducts ----
struct EmailNotification;
impl Notification for EmailNotification {
    fn send(&self, message: &str) {
        println!("[Email] Enviando: {}", message);
    }
}

struct SmsNotification;
impl Notification for SmsNotification {
    fn send(&self, message: &str) {
        println!("[SMS] Enviando: {}", message);
    }
}

struct PushNotification;
impl Notification for PushNotification {
    fn send(&self, message: &str) {
        println!("[Push] Enviando: {}", message);
    }
}

// ---- Creator ----
trait NotificationFactory {
    // Factory Method: cada implementacao decide qual Notification criar
    fn create_notification(&self) -> Box<dyn Notification>;

    // Usa o factory method sem conhecer o tipo concreto
    fn notify(&self, message: &str) {
        let notification = self.create_notification();
        notification.send(message);
    }
}

// ---- ConcreteCreators ----
struct EmailNotificationFactory;
impl NotificationFactory for EmailNotificationFactory {
    fn create_notification(&self) -> Box<dyn Notification> {
        Box::new(EmailNotification)
    }
}

struct SmsNotificationFactory;
impl NotificationFactory for SmsNotificationFactory {
    fn create_notification(&self) -> Box<dyn Notification> {
        Box::new(SmsNotification)
    }
}

struct PushNotificationFactory;
impl NotificationFactory for PushNotificationFactory {
    fn create_notification(&self) -> Box<dyn Notification> {
        Box::new(PushNotification)
    }
}

fn main() {
    let factories: Vec<Box<dyn NotificationFactory>> = vec![
        Box::new(EmailNotificationFactory),
        Box::new(SmsNotificationFactory),
        Box::new(PushNotificationFactory),
    ];

    // O cliente so conhece a trait NotificationFactory / Notification.
    for factory in &factories {
        factory.notify("Pedido #1234 confirmado!");
    }
}
