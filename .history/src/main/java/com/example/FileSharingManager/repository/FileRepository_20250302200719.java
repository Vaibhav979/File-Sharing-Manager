package com.example.FileSharingManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FileSharingManager.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Integer>{
    @Query
    List<FileEntity> findByExpiryDate(String username);
}
