package com.sherpa.SpringAi;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GenAiController {
    ChatService chatService;
    ImageService imageService;

    public GenAiController(ChatService chatService, ImageService imageService) {
        this.chatService = chatService;
        this.imageService = imageService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompts) {
        return chatService.getMessage(prompts);
    }

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompts) {
        return chatService.getResponseOptions(prompts);
    }

    @GetMapping("generate-image")
    public void generateImageResponse(HttpServletResponse httpServletResponse, @RequestParam String prompts) throws IOException {

        ImageResponse imageResponse = imageService.generateImageResponse(prompts);
        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        httpServletResponse.sendRedirect(imageUrl);
    }
}
