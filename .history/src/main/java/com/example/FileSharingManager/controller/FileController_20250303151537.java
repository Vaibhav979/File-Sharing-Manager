package com.example.FileSharingManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String postMethodName(@RequestParam("file") Multipart file, @RequestParam)
}
