package com.sparta.leehy.lesson.domain.vector.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimilaritySearchRequest {

    UUID documentId;

    String query;

    Integer topK;

}