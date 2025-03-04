package com.example.FileSharingManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileSharingManager.entity.FileEntity;
import java.util.List;
import java.time.LocalDateTime;

@Re
public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    List<FileEntity> findByExpiryDate(LocalDateTime now);
}
