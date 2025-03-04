package com.example.FileSharingManager.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileSharingManager.services.FileServiceImpl;

@Controller
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
    public String shareFile(@PathVariable int id, Model model){
        ResponseEntity<?> response = fileService.shareFile(id);
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequest().toString(); //url
        model.addAttribute
    }
}
