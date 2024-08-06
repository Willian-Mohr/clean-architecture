package com.wohr.infrastructure.controllers;

import com.wohr.infrastructure.dto.requests.TransferRequest;
import com.wohr.infrastructure.dto.responses.BaseResponse;
import com.wohr.infrastructure.dto.responses.ConsultBalanceResponse;
import com.wohr.usecase.ConsultBalanceUseCase;
import com.wohr.usecase.TransferUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    private final ConsultBalanceUseCase consultBalanceUseCase;
    private final TransferUseCase transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {

        var balance = consultBalanceUseCase.consult(taxNumber);

        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {

        transferUseCase.transfer(transferRequest.fromTaxNumber(), transferRequest.toTaxNumber(), transferRequest.value(), transferRequest.pin());

        return BaseResponse.<String>builder().success(true).message("Transfer completed successfully").build();
    }
}
