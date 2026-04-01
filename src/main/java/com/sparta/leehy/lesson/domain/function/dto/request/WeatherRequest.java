package com.sparta.leehy.lesson.domain.function.dto.request;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeatherRequest {

    @JsonPropertyDescription("도시를 설명합니다. (예, 서울, 뉴욕, 도쿄)")
    private String city;

}