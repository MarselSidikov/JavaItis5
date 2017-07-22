package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ru.itis.service.FilesService;
import sun.security.tools.policytool.Resources_es;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class FilesController {

    @Autowired
    private FilesService service;

    @PostMapping("/files")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String filePath = service.saveFile(file);
        return ResponseEntity
                .ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public ResponseEntity<byte[]> getFile(@PathVariable("file-name") String fileName) throws IOException {
        File fromFileSystem = new File("files\\" + fileName);
        long length = fromFileSystem.length();
        byte bytes[] = new byte[100];
        new FileInputStream(fromFileSystem).read(bytes);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(bytes);
    }
}
