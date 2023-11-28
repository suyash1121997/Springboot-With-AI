package com.chatgpt.chatgpt.integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IChatGptController {


    @GetMapping("/getChat")
    String getChat(@RequestParam("prompt") String prompt);
}
