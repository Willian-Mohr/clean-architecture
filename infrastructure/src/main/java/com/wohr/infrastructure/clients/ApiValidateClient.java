package com.wohr.infrastructure.clients;

import com.wohr.infrastructure.clients.dto.responses.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "apiValidateClient", url = "${client.url}")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse valide();
}
