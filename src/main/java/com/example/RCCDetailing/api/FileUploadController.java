package com.example.RCCDetailing.api;

import com.example.RCCDetailing.model.Structure;
import com.example.RCCDetailing.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("api/v1/upload")
@RestController
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;
    @PostMapping
    public Structure uploadFile(@RequestParam("file") MultipartFile file){
        return fileUploadService.uploadFile(file);
    }
}
