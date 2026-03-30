package com.sparta.leehy.lesson.domain.vector.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "vector_documents")
public class VectorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    String fileName;

    @Column(nullable = false, columnDefinition = "TEXT")
    String content;

    @Column(nullable = false, length = 50)
    String contentType;

    @Column(columnDefinition = "TEXT")
    String metadata;

    @Setter
    @Column(nullable = false)
    Integer chunkCount;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Builder
    public VectorDocument(
            UUID id,
            String fileName,
            String content,
            String contentType,
            String metadata,
            Integer chunkCount
    ) {
        this.id = id;
        this.fileName = fileName;
        this.content = content;
        this.contentType = contentType;
        this.metadata = metadata;
        this.chunkCount = chunkCount;
    }
}