package com.chatgpt.chatgpt.integration.config;

import com.chatgpt.chatgpt.integration.dto.ChatGptRequestModel;
import com.chatgpt.chatgpt.integration.dto.ChatGptResponseModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
@Component
public class MyWebClient<T> {
    @Value("${chatgpt.api.key}")
    String apiKey;
    @Value("${chatgpt.api.url}")
    String apiUrl;
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ChatGptResponseModel callChatGpt(WebClient webClient, ChatGptRequestModel requestBody) {
        return webClient.post()
                .uri("")
                .body(BodyInserters.fromValue(requestBody))
                .retrieve()
                .bodyToMono(ChatGptResponseModel.class)
                .block();
    }
}
