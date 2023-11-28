package com.chatgpt.chatgpt.integration.controller.impl;

import com.chatgpt.chatgpt.integration.controller.IChatGptController;
import com.chatgpt.chatgpt.integration.service.IChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGptController implements IChatGptController {
    @Autowired
    private IChatGptService chatGptService;
    @Override
    public String getChat(String prompt) {

        return chatGptService.callChatGpt(prompt);
    }
}
