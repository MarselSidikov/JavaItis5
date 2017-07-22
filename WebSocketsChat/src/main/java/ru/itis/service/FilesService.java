package ru.itis.service;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.model.File;

import java.io.InputStream;

public interface FilesService {
    String saveFile(MultipartFile file);

    File getFile(String storageFileName);

    InputStream getFileInputStream(File file);
}
