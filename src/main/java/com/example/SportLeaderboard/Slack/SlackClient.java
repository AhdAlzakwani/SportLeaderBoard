package com.example.SportLeaderboard.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {
    public String sendMessage(String text) {

        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
