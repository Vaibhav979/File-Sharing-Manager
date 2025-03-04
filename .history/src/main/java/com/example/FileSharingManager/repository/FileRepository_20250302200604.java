package com.example.FileSharingManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileSharingManager.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity>{
    
}
