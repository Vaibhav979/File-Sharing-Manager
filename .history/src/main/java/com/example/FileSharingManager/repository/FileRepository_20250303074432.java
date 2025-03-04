package com.example.FileSharingManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileSharingManager.entity.FileEntity;
import java.util.List;
import java.time.LocalDateTime;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    // @Query
    List<FileEntity> findByExpiryDate(LocalDateTime now);
}
