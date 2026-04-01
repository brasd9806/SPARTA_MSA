package com.sparta.leehy.lesson.domain.function.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherResponse {

    String city;
    int temperature;
    String condition;
    LocalDateTime timestamp;

}