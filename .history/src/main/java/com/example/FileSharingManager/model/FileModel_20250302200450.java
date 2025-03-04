package com.example.FileSharingManager.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class FileModel {
    private int id;
    private String filename;
    private String uploadedBy;
    private LocalDateTime uploadTime;
    private LocalDateTime expiryTime;

    private byte[] fileData
}
