package com.wohr.infrastructure.clients;

import com.wohr.infrastructure.clients.dto.responses.ApiValidateResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiValidateService {

    private final ApiValidateClient apiValidateClient;

    public ApiValidateService(ApiValidateClient apiValidateClient) {
        this.apiValidateClient = apiValidateClient;
    }

    public ApiValidateResponse validate() {
        try {
            return apiValidateClient.valide();
        } catch (Exception e) {
            return null;
        }
    }
}
