package com.sparta.leehy.lesson.domain.vector.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimilaritySearchResponse {

    String query;

    int resultCount;

    List<SearchResult> results;

    @Getter
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class SearchResult {

        String id;

        String content;

        Map<String, Object> metadata;

    }
}