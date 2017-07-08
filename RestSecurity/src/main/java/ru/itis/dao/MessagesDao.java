package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Message;

public interface MessagesDao extends JpaRepository<Message, Integer> {
}
