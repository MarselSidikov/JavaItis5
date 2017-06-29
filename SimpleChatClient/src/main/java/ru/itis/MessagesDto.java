package ru.itis;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class MessagesDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MessageDto> messages;

    public MessagesDto() {
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    public String toString() {
        return messages.toString();
    }
}
