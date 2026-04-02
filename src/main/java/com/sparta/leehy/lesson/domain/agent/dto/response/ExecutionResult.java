package com.sparta.leehy.lesson.domain.agent.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExecutionResult {

    String goal;
    String plan;
    List<StepResult> stepResults;
    String finalResult;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class StepResult {

        int stepNumber;
        String description;
        String result;
    }

}