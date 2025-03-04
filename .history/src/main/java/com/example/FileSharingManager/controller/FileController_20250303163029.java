package com.example.FileSharingManager.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.FileSharingManager.services.FileServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping
public class FileController {

    @Autowired
    FileServiceImpl fileService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("files", fileService.getAll());
        return "list-files";
    }

    @PostMapping("/upload")
    public String postMethodName(@RequestParam("file") MultipartFile file,
            @RequestParam("uploadedBy") String uploadedBy)
            throws IOException {
        return "redirect:/";
    }

    @GetMapping("/share/{id}")
    public String shareFile(@PathVariable int id, Model model) {
        ResponseEntity<?> fileModel = fileService.shareFile(id);
        if (fileModel.hasBody()) {
            String currentUrl = ServletUriComponentsBuilder.fromCurrentRequest().toString(); // url
            model.addAttribute("shareUrl", currentUrl);
            model.addAttribute("file", fileModel.getBody());
            return "share-file";
        } else {
            return "redirect:/";
        }
    }

    // @PostMapping("/delete/{id}")
    // public String postMethodName(@RequestBody String entity) {
    // //TODO: process POST request

    // return entity;
    // }

}
