package test.vkbot.VkBot.dto;

import lombok.Data;

@Data
public class RequestParamsDto {
    private String url;
    private String accessToken;
    private String apiVersion;
    private String message;
    private Integer userId;
}
