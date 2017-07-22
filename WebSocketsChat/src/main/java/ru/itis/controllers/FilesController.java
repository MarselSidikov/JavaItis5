package ru.itis.controllers;

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
import sun.security.tools.policytool.Resources_es;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class FilesController {

    private long size;

    @PostMapping("/files")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), Paths.get("files", file.getOriginalFilename()));
            size = file.getSize();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/files/{file-name:.+}")
    public ResponseEntity<byte[]> getFile(@PathVariable("file-name") String fileName) throws IOException {
        File fromFileSystem = new File("files\\" + fileName);
        long length = fromFileSystem.length();
        byte bytes[] = new byte[(int) size];
        new FileInputStream(fromFileSystem).read(bytes);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(bytes);
    }
}
