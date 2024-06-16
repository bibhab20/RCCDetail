package com.example.RCCDetailing.api;

import com.example.RCCDetailing.model.Structure;
import com.example.RCCDetailing.model.StructureResponse;
import com.example.RCCDetailing.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("api/v1/upload")
@RestController
@CrossOrigin(origins = {"http://rccdetaillingfront.herokuapp.com/","http://localhost:3000/","https://rccdetailling-frontend.herokuapp.com/"})
@Slf4j
public class FileUploadController {
    @Autowired
    FileUploadService fileUploadService;
    @PostMapping
    public StructureResponse uploadFile(@RequestParam("file") MultipartFile file){
        log.info("Reading file {}", file.getName());
        return fileUploadService.uploadFile(file);
    }
}
