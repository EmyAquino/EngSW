#include <stdio.h>

/* ---- Product ----
   C nao tem interfaces/classes; emulamos com um "vtable" (struct de ponteiro
   de funcao). Cada Notification concreta so precisa preencher esse ponteiro. */
typedef struct Notification {
    void (*send)(const char *message);
} Notification;

/* ---- ConcreteProducts ---- */
void email_send(const char *message) { printf("[Email] Enviando: %s\n", message); }
void sms_send(const char *message)   { printf("[SMS] Enviando: %s\n", message); }
void push_send(const char *message)  { printf("[Push] Enviando: %s\n", message); }

Notification make_email_notification(void) { Notification n = { email_send }; return n; }
Notification make_sms_notification(void)   { Notification n = { sms_send };   return n; }
Notification make_push_notification(void)  { Notification n = { push_send };  return n; }

/* ---- Creator ----
   Guarda o "factory method" como um ponteiro de funcao que devolve um
   Notification. Cada fabrica concreta aponta para uma make_*_notification. */
typedef struct NotificationFactory {
    Notification (*createNotification)(void);
} NotificationFactory;

void notify(NotificationFactory *factory, const char *message) {
    Notification n = factory->createNotification();  /* factory method */
    n.send(message);
}

int main(void) {
    /* ---- ConcreteCreators ----
       cada entrada do array e uma "fabrica concreta" diferente */
    NotificationFactory factories[] = {
        { make_email_notification },
        { make_sms_notification },
        { make_push_notification },
    };
    int total = (int)(sizeof(factories) / sizeof(factories[0]));

    /* O cliente so conhece NotificationFactory/Notification, nunca as
       funcoes concretas de send/create. */
    for (int i = 0; i < total; i++) {
        notify(&factories[i], "Pedido #1234 confirmado!");
    }
    return 0;
}
