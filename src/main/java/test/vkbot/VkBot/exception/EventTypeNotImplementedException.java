package test.vkbot.VkBot.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class EventTypeNotImplementedException extends ResponseStatusException {

    public EventTypeNotImplementedException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
