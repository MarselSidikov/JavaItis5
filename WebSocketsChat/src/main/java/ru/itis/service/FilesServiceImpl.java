package ru.itis.service;

import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.repository.FilesDao;
import ru.itis.model.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

@Service
public class FilesServiceImpl implements FilesService {

    @Value("${storage.path}")
    private String storagePath;

    @Autowired
    private FilesDao filesDao;

    private SecureRandom random = new SecureRandom();

    @Override
    public String saveFile(MultipartFile file) {
        File storageFile = convertFromMultipart(file);
        filesDao.save(storageFile);
        copyToStorage(file, storageFile.getStorageName());
        return storageFile.getStorageName();
    }

    @NotNull
    private String getUrlOfFile(String storageName) {
        return storagePath + "\\" + storageName;
    }

    private File convertFromMultipart(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String type = file.getContentType();
        long size = file.getSize();
        String storageName = createStorageName(originalFileName);
        String fileUrl = getUrlOfFile(storageName);
        return new File(originalFileName, storageName, fileUrl , size, type);
    }

    private String createStorageName(String originalFileName) {
        String hash = new BigInteger(130, random).toString(20);
        String extension = FilenameUtils.getExtension(originalFileName);
        String fileName = originalFileName.substring(0, originalFileName.indexOf("." + extension));
        return fileName + hash + "." + extension;
    }

    private void copyToStorage(MultipartFile file, String storageName) {
        try {
            Files.copy(file.getInputStream(), Paths.get("files", storageName));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public File getFile(String storageFileName) {
        return filesDao.findFirstByStorageName(storageFileName);
    }

    @Override
    public InputStream getFileInputStream(File file) {
        try {
            return new FileInputStream(new java.io.File(file.getUrl()));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
