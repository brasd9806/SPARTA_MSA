CREATE TABLE chat_conversations
(
    id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(), -- 서버쪽에서 ID를 결정하고 싶어서
    title      VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE chat_messages -- 채팅방에 포함 되는 메세지
(
    id                BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    conversation_id   UUID        NOT NULL,
    role              VARCHAR(20) NOT NULL, -- USER, ASSISTANT, SYSTEM, SUMMARY(10개를 하나로 압축)
    status            VARCHAR(20) NOT NULL, -- ACTIVE, INACTIVE, DELETED
    message           TEXT        NOT NULL,
    prompt_tokens     INT,
    completion_tokens INT,
    total_tokens      INT,
    created_at        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);