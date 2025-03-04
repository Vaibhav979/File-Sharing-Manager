package com.example.FileSharingManager.services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileSharingManager.entity.FileEntity;
import com.example.FileSharingManager.model.FileModel;
import com.example.FileSharingManager.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    private FileModel convertToModel(FileEntity entity) {
        FileModel model = new FileModel();
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    @Override
    public List<FileModel> getAll() {
        List<FileEntity> entities = fileRepository.findAll();
        return entities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> uploadFile(MultipartFile file, String uploadedBy) throws IOException {
        FileEntity entity = new FileEntity();
        entity.setFilename(file.getOriginalFilename());
        entity.setUploadedBy(uploadedBy);
        entity.setExpiryTime(LocalDateTime.now().plusDays(1));
        entity.setUploadTime(LocalDateTime.now());
        entity.setFileData(file.getBytes());
        fileRepository.save(entity);
        return ResponseEntity.ok().body(convertToModel(entity));
    }

    @Override
    public ResponseEntity<?> shareFile(int id) {
        Optional<FileModel> file = fileRepository.findById();
        if(entity)
    }

    @Override
    public ResponseEntity<?> deleteFile(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFile'");
    }

}
