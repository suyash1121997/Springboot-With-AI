package com.chatgpt.chatgpt.integration.service.impl;

import com.chatgpt.chatgpt.integration.config.MyWebClient;
import com.chatgpt.chatgpt.integration.dto.ChatGptRequestModel;
import com.chatgpt.chatgpt.integration.dto.ChatGptResponseModel;
import com.chatgpt.chatgpt.integration.service.IChatGptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ChatGptServiceImpl implements IChatGptService {
    @Autowired
    private MyWebClient<ChatGptResponseModel> modelMyWebClient;
    @Autowired
    WebClient webClient;
    @Override
    public String callChatGpt(String prompt) {
        ChatGptRequestModel chatGptRequestModel = new ChatGptRequestModel("user", prompt);
        return modelMyWebClient.callChatGpt(webClient, chatGptRequestModel).getChoices().get(0).getMessage().getContent();
    }
}
