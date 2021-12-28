package com.example.RCCDetailing.api;

import com.example.RCCDetailing.model.Structure;
import com.example.RCCDetailing.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("api/v1/upload")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;
    @PostMapping
    public Structure uploadFile(@RequestParam("file") MultipartFile file){
        return fileUploadService.uploadFile(file);
    }
}
