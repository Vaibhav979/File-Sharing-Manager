package com.example.FileSharingManager.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileSharingManager.entity.FileEntity;
import com.example.FileSharingManager.model.FileModel;
import com.example.FileSharingManager.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileRepository fileRepository;

    private FileModel convertTModel(FileEntity entity)

    @Override
    public List<FileModel> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadFile'");
    }

    @Override
    public ResponseEntity<?> shareFile(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shareFile'");
    }

    @Override
    public ResponseEntity<?> deleteFile(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }
    
}
