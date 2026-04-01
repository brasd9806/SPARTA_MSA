package com.sparta.leehy.lesson.domain.function.controller;

import com.sparta.leehy.lesson.domain.function.service.FunctionCallingService;
import com.sparta.leehy.lesson.domain.rag.dto.request.QuestionRequest;
import com.sparta.leehy.lesson.domain.rag.dto.response.AnswerResponse;
import com.sparta.leehy.lesson.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/function")
public class FunctionCallingController {

    private final FunctionCallingService functionCallingService;

    /**
     * 기본 Function Calling 채팅 인터페이스
     */
    @PostMapping("/chat")
    public ApiResponse<AnswerResponse> chat(@RequestBody QuestionRequest request) {
        String result = functionCallingService.chat(request.getQuestion());
        return ApiResponse.ok(AnswerResponse.builder().answer(result).build());
    }

}
