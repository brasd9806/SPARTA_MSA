package com.sparta.leehy.lesson.domain.vector.repository;

import com.sparta.leehy.lesson.domain.vector.entity.VectorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VectorDocumentRepository extends JpaRepository<VectorDocument, UUID> {

}