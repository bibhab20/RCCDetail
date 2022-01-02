package com.example.RCCDetailing.service;

import com.example.RCCDetailing.model.*;
import com.example.RCCDetailing.service.analysis.ColumnLineAnalyzer;
import com.example.RCCDetailing.service.analysis.StructureTester;
import com.example.RCCDetailing.service.parser.Parser;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class FileUploadService {
    public StructureResponse  uploadFile(MultipartFile file) {
        String text ="";
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String st;
            StringBuilder sb = new StringBuilder();
            while ((st = bufferedReader.readLine()) != null)
                sb.append(st).append("\n");
            text = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Parser parser = new Parser();
        Structure structure = (Structure) parser.getStructure(text);
        StructureTester tester = new StructureTester();
        ColumnLineAnalyzer columnLineAnalyzer = new ColumnLineAnalyzer();
        StructureResponseAdapter responseAdapter = new StructureResponseAdapter();
        return responseAdapter.getStructureResponse(structure,columnLineAnalyzer.getColumnLines(structure));
    }
}
