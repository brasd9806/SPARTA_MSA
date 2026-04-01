package com.sparta.leehy.lesson.domain.function.tools;


import com.sparta.leehy.lesson.domain.function.dto.request.CalculatorRequest;
import com.sparta.leehy.lesson.domain.function.dto.request.WeatherRequest;
import com.sparta.leehy.lesson.domain.function.dto.response.CalculatorResponse;
import com.sparta.leehy.lesson.domain.function.dto.response.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Service
public class FunctionTools {

    @Tool(description = "특정 도시의 현재 날씨 정보를 조회합니다")
    public WeatherResponse getWeather(WeatherRequest request) {
        log.info("날씨 조회: {}", request.getCity());

        Random random = new Random();
        int temperature = 10 + random.nextInt(20);
        String[] conditions = {"맑음", "흐림", "비", "눈"};
        String condition = conditions[random.nextInt(conditions.length)];

        return WeatherResponse.builder()
                .city(request.getCity())
                .temperature(temperature)
                .condition(condition)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Tool(description = "특정 숫자의 ")
    public CalculatorResponse getCalculator(CalculatorRequest request) {
        log.info("숫자 조회 {} {} {}", request.getA(), request.getOperation(), request.getB());

        double result = switch (request.getOperation()) {
            case "add" -> request.getA() + request.getB();
            case "subtract" -> request.getA() - request.getB();
            case "multiply" -> request.getA() * request.getB();
            case "divide" -> {
                if (request.getB() == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다");
                }
                yield request.getA() / request.getB();
            }
            default -> throw new IllegalArgumentException("지원하지 않는 연산: " + request.getOperation());
        };

        return CalculatorResponse.builder()
                .result(result)
                .build();
    }
}
