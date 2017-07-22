package ru.itis.service;

import org.springframework.web.multipart.MultipartFile;

public interface FilesService {
    String saveFile(MultipartFile file);
    byte[] getFile(String storageFileName);
}
