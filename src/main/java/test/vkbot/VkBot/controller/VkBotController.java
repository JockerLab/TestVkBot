package test.vkbot.VkBot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.vkbot.VkBot.dto.VkBotEventDto;
import test.vkbot.VkBot.exception.BadEventRequestException;
import test.vkbot.VkBot.exception.EventTypeNotImplementedException;
import test.vkbot.VkBot.exception.UnauthorizedEventException;
import test.vkbot.VkBot.service.VkBotService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VkBotController {
    @Value("${vk.bot.confirmation-token}")
    private String CONFIRMATION_TOKEN;
    @Value("${vk.bot.secret}")
    private String BOT_SECRET;
    @Value("${vk.bot.id}")
    private Long BOT_ID;
    private final VkBotService vkBotService;

    @PostMapping
    public String onSendEvent(@RequestBody VkBotEventDto event) {
        if (event.getType().equals("confirmation")) {
            return CONFIRMATION_TOKEN;
        }

        if (!event.getType().equals("message_new")) {
            throw new EventTypeNotImplementedException(
                HttpStatus.NOT_IMPLEMENTED,
                "Event type not implemented"
            );
        }

        if (event.getSecret() == null || !event.getSecret().equals(BOT_SECRET)) {
            throw new UnauthorizedEventException(
                HttpStatus.UNAUTHORIZED,
                "Not authorized event"
            );
        }

        if (!event.getGroup_id().equals(BOT_ID)) {
            throw new BadEventRequestException(
                HttpStatus.BAD_REQUEST,
                "Wrong bot id"
            );
        }

        this.vkBotService.respondMessage(event);

        return "ok";
    }
}
