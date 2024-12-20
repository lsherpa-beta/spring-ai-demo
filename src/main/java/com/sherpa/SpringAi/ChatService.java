package com.sherpa.SpringAi;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getMessage(String prompts) {
        return chatModel.call(prompts);
    }

    public String getResponseOptions(String prompts) {
        ChatResponse chatResponse = chatModel.call(
                new Prompt(
                        prompts,
                        OpenAiChatOptions.builder()
                                .withModel("gpt-4o")
                                .withTemperature(0.4)
                                .build()
                ));
        return chatResponse.getResult().getOutput().getContent();
    }


}

