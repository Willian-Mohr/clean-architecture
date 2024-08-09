package com.wohr.infrastructure.controllers;

import com.wohr.infrastructure.dto.requests.CreateUserRequest;
import com.wohr.infrastructure.dto.responses.BaseResponse;
import com.wohr.infrastructure.mappers.UserMapper;
import com.wohr.usecase.CreateUserUseCase;
import com.wohr.usecase.EmailAvailableUseCase;
import com.wohr.usecase.TaxNumberAvailableUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;
    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private final EmailAvailableUseCase emailAvailableUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Start of user creation::UserController");
        emailAvailableUseCase.emailAvailable(request.email());
        taxNumberAvailableUseCase.taxNumberAvailable(request.taxNumber());
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully::UserController");
        return BaseResponse.<String>builder().success(true).message("User created successfully").build();
    }
}
