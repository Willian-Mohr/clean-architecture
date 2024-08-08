package com.wohr.infrastructure.clients.user.notificate;

import org.springframework.stereotype.Service;

@Service
public class NotificationClientService {

    private final NotificationClient notificationClient;

    public NotificationClientService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public Boolean notification(){
        return notificationClient.notification().success();
    }
}
