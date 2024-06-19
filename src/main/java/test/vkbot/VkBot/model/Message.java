package test.vkbot.VkBot.model;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private Integer from_id;
    private String text;
}
