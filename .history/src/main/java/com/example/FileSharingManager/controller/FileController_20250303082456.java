package com.example.FileSharingManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {
    @GetMapping("/")
    public String index(Model model) {
        return "list-files";
    }
}
