package test.vkbot.VkBot.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import test.vkbot.VkBot.dto.RequestParamsDto;

@Service
public class HttpService {
    public String sendRequest(RequestParamsDto params) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(params.getUrl())
                .queryParam("access_token", params.getAccessToken())
                .queryParam("v", params.getApiVersion())
                .queryParam("message", params.getMessage())
                .queryParam("peer_id", params.getUserId())
                .queryParam("random_id", "0");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = restTemplate.exchange(
                builder.build().toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
