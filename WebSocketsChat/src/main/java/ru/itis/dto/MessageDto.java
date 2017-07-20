package ru.itis.dto;

public class MessageDto {
    private int chatId;
    private String from;
    private String message;

    public MessageDto() {
    }

    public MessageDto(int chatId, String from, String message) {
        this.chatId = chatId;
        this.from = from;
        this.message = message;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
