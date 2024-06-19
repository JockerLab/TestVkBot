package test.vkbot.VkBot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import test.vkbot.VkBot.dto.RequestParamsDto;
import test.vkbot.VkBot.dto.VkBotEventDto;

@Service
@RequiredArgsConstructor
public class VkBotService {
    @Value("${vk.api.url}")
    private String VK_API_URL;
    @Value("${vk.api.token}")
    private String VK_API_TOKEN;
    @Value("${vk.api.version}")
    private String VK_API_VERSION;
    @Value("${vk.bot.id}")
    private Long BOT_ID;
    private final HttpService httpService;

    public void respondMessage(VkBotEventDto event) {
        String responseUrl = VK_API_URL + "/method/messages.send?";
        Integer userId = event.getObject().getMessage().getFrom_id();
        String message = "Вы написали: \"" + event.getObject().getMessage().getText() + "\"";

        RequestParamsDto params = new RequestParamsDto();
        params.setUrl(responseUrl);
        params.setUserId(userId);
        params.setAccessToken(VK_API_TOKEN);
        params.setApiVersion(VK_API_VERSION);
        params.setMessage(message);

        String response = httpService.sendRequest(params);

        System.out.println("Response: " + response);
    }
}
