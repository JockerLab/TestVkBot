package test.vkbot.VkBot.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BadEventRequestException extends ResponseStatusException {

    public BadEventRequestException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
