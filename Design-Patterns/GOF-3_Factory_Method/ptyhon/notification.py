from abc import ABC, abstractmethod


# ---- Product ----
class Notification(ABC):
    @abstractmethod
    def send(self, message: str) -> None:
        ...


# ---- ConcreteProducts ----
class EmailNotification(Notification):
    def send(self, message: str) -> None:
        print(f"[Email] Enviando: {message}")


class SMSNotification(Notification):
    def send(self, message: str) -> None:
        print(f"[SMS] Enviando: {message}")


class PushNotification(Notification):
    def send(self, message: str) -> None:
        print(f"[Push] Enviando: {message}")


# ---- Creator ----
class NotificationFactory(ABC):
    @abstractmethod
    def create_notification(self) -> Notification:
        """Factory Method: cada subclasse decide qual Notification criar."""
        ...

    def notify(self, message: str) -> None:
        """Usa o factory method sem conhecer a classe concreta."""
        notification = self.create_notification()
        notification.send(message)


# ---- ConcreteCreators ----
class EmailNotificationFactory(NotificationFactory):
    def create_notification(self) -> Notification:
        return EmailNotification()


class SMSNotificationFactory(NotificationFactory):
    def create_notification(self) -> Notification:
        return SMSNotification()


class PushNotificationFactory(NotificationFactory):
    def create_notification(self) -> Notification:
        return PushNotification()


def main() -> None:
    factories = [
        EmailNotificationFactory(),
        SMSNotificationFactory(),
        PushNotificationFactory(),
    ]

    # O cliente conhece apenas NotificationFactory / Notification.
    for factory in factories:
        factory.notify("Pedido #1234 confirmado!")


if __name__ == "__main__":
    main()
