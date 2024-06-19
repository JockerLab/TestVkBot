package test.vkbot.VkBot.dto;

import lombok.Data;
import lombok.NonNull;
import test.vkbot.VkBot.model.MessageObject;

@Data
public class VkBotEventDto {
    @NonNull
    private String type;
    private MessageObject object;
    @NonNull
    private Long group_id;
    private String secret;
}
