package test.vkbot.VkBot.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class UnauthorizedEventException extends ResponseStatusException {

    public UnauthorizedEventException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
