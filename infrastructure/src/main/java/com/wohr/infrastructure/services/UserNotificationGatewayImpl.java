package com.wohr.infrastructure.services;

import com.wohr.application.gateway.UserNotificationGateway;
import com.wohr.core.domain.Transaction;
import com.wohr.infrastructure.clients.user.notificate.NotificationClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserNotificationGatewayImpl implements UserNotificationGateway {

    private final NotificationClientService notificationClientService;

    public UserNotificationGatewayImpl(NotificationClientService notificationClientService) {
        this.notificationClientService = notificationClientService;
    }

    @Override
    public Boolean notify(Transaction transaction, String email) {

        log.info("Starting user notification::UserNotificationGatewayImpl");

        var response = notificationClientService.notification();

        if (response) {
            log.info("User notified successfully::UserNotificationGatewayImpl");
        }

        return response;
    }
}
