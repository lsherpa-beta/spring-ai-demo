package com.sherpa.SpringAi;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final StabilityAiImageModel stabilityAiImageModel;

    public ImageService(StabilityAiImageModel stabilityAiImageModel) {
        this.stabilityAiImageModel = stabilityAiImageModel;
    }

    public ImageResponse generateImageResponse(String prompts) {
        ImageResponse imageResponse = stabilityAiImageModel.call(
                new ImagePrompt(prompts));
        
        return imageResponse;
    }
}
