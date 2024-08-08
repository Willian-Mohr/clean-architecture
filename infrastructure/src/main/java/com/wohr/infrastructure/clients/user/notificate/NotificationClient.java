package com.wohr.infrastructure.clients.user.notificate;

import com.wohr.infrastructure.clients.user.notificate.responses.NotificationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotificationClient", url = "${client.user.url}")
public interface NotificationClient {

    @GetMapping
    NotificationResponse notification();
}