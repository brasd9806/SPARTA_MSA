package com.sparta.leehy.lesson.domain.user.controller;

import com.sparta.leehy.lesson.domain.user.dto.request.UserRequest;
import com.sparta.leehy.lesson.domain.user.dto.response.UserResponse;
import com.sparta.leehy.lesson.domain.user.service.UserService;
import com.sparta.leehy.lesson.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {

        return ApiResponse.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {
        return ApiResponse.ok(userService.getUserById(id));
    }

    // 회원 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponse> create(@RequestBody UserRequest request) {
        return ApiResponse.ok(userService.create(request));
    }

}
