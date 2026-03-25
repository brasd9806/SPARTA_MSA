package com.sparta.leehy.lesson.domain.ai.repository;

import com.sparta.leehy.lesson.domain.ai.entity.ChatConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatConversationRepository extends JpaRepository<ChatConversation, UUID> {

}