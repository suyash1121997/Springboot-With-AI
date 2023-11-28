package com.chatgpt.chatgpt.integration.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ChatGptRequestModel {
    private String model;
    private List<Message> message;

    public ChatGptRequestModel(String model, String prompt) {
        this.model = model;
        this.message = new ArrayList<>();
        this.message.add(Message.builder().role("user").content(prompt).build());

    }
}
