package com.wohr.infrastructure.controllers;

import com.wohr.core.exception.NotificationException;
import com.wohr.core.exception.enums.ErrorCodeEnum;
import com.wohr.infrastructure.dto.requests.TransferRequest;
import com.wohr.infrastructure.dto.responses.BaseResponse;
import com.wohr.infrastructure.dto.responses.ConsultBalanceResponse;
import com.wohr.usecase.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {

    private final ConsultBalanceUseCase consultBalanceUseCase;
    private final TransferUseCase transferUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final TransactionPinValidateUseCase transactionPinValidateUseCase;
    private final UserNotificationUseCase userNotificationUseCase;
    private final TransactionValidateUseCase transactionValidateUseCase;


    public WalletController(ConsultBalanceUseCase consultBalanceUseCase, TransferUseCase transferUseCase, CreateTransactionUseCase createTransactionUseCase, FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionPinValidateUseCase transactionPinValidateUseCase, UserNotificationUseCase userNotificationUseCase, TransactionValidateUseCase transactionValidateUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionPinValidateUseCase = transactionPinValidateUseCase;
        this.userNotificationUseCase = userNotificationUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(@PathVariable String taxNumber) throws Exception {

        var balance = consultBalanceUseCase.consult(taxNumber);

        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws Exception {

        var fromWallet = findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.fromTaxNumber());

        transactionPinValidateUseCase.validate(fromWallet.getTransactionPin(), transferRequest.pin());

        var toWallet = findWalletByTaxNumberUseCase.findByTaxNumber(transferRequest.toTaxNumber());

        var transaction = createTransactionUseCase.create(fromWallet, toWallet, transferRequest.value());

        transactionValidateUseCase.validate(transaction);

        transferUseCase.transfer(transaction);

        if (!userNotificationUseCase.notify(transaction, toWallet.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NO0001.getMessage(), ErrorCodeEnum.NO0001.getCode());
        }

        return BaseResponse.<String>builder().success(true).message("Transfer completed successfully").build();
    }
}
