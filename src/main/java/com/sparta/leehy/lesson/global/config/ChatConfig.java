package com.sparta.leehy.lesson.global.config;

import com.sparta.leehy.lesson.domain.ai.advisor.ChatMemoryAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        ChatMemoryAdvisor myAdvisor = new ChatMemoryAdvisor("user-123", 10);

        // yml에 등록된 설정을 바탕으로 ChatClient를 생성하며,
        // 공통 지침(defaultSystem)만 여기서 추가합니다.
        return builder
                .defaultSystem("""
                        당신은 친절하고 도움이 되는 AI 어시스턴트입니다.
                        사용자의 질문에 정확하고 이해하기 쉽게 답변해주세요.
                        """)
                .defaultAdvisors(myAdvisor) // 직접 만든 어드바이저 장착
                .build();
    }
}