package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.File;

public interface FilesDao extends JpaRepository<File, Integer> {
    File findFirstByStorageName(String name);
}
