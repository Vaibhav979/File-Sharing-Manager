package com.example.FileSharingManager.entity;

import jakarta.persistence.Entity;

@Entity
public class FileEntity {
    private int id;
    private String filename;
    private String uploadedBy;
    private LocalDateTime uploadTime;
}
