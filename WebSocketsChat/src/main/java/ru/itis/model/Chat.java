package ru.itis.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "chats")
    private List<User> users;

    public Chat() {
    }

    public Chat(User creator, List<Message> messages, String name, List<User> users) {
        this.creator = creator;
        this.messages = messages;
        this.name = name;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
