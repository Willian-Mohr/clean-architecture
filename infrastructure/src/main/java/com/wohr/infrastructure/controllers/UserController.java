package com.wohr.infrastructure.controllers;

import com.wohr.infrastructure.dto.requests.CreateUserRequest;
import com.wohr.infrastructure.dto.responses.BaseResponse;
import com.wohr.infrastructure.mappers.UserMapper;
import com.wohr.usecase.CreateUserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping("/createUser")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        log.info("Start of user creation::UserController");
        createUserUseCase.create(userMapper.toUser(request), request.pin());
        log.info("User created successfully::UserController");
        return BaseResponse.<String>builder().success(true).message("User created successfully").build();
    }
}
