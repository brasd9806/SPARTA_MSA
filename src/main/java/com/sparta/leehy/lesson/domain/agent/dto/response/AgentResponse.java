package com.sparta.leehy.lesson.domain.agent.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AgentResponse {

    String mode;
    String goal;
    String problem;
    List<String> usedTools;
    Integer iterations;
    String result;

}