package com.chatgpt.chatgpt.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponseModel {
    private List<Choice> choices;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class  Choice {
        private int index;
        private Message message;
    }
}
