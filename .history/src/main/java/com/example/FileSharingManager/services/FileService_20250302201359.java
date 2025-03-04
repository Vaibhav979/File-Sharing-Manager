package com.example.FileSharingManager.services;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.example.FileSharingManager.model.FileModel;

public interface FileService {
    public List<FileModel> getAll();
    public ResponseEntity<?> uploadFile(MultiPart)
}
