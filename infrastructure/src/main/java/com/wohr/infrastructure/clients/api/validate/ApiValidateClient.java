package com.wohr.infrastructure.clients.api.validate;

import com.wohr.infrastructure.clients.api.validate.responses.ApiValidateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "apiValidateClient", url = "${client.api.url}")
public interface ApiValidateClient {

    @GetMapping
    ApiValidateResponse valide();
}
