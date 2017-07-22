package ru.itis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.model.File;
import ru.itis.service.FilesService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FilesController {

    @Autowired
    private FilesService service;

    @PostMapping("/files")
    public ResponseEntity<String> handleFileUpload(@RequestHeader("Auth-Token") String token, @RequestParam("file") MultipartFile file) {
        String filePath = service.saveFile(file);
        return ResponseEntity
                .ok()
                .body(filePath);
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@RequestHeader("Auth-Token") String token, @PathVariable("file-name") String fileName,
                        HttpServletResponse response) {
        File file = service.getFile(fileName);
        response.setContentType(file.getType());
        writeFileToResponse(file, response);
    }

    private void writeFileToResponse(File file, HttpServletResponse response) {
        try {
            InputStream inputStream = service.getFileInputStream(file);
            org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
