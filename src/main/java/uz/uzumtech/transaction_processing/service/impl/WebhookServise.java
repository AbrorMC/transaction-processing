package uz.uzumtech.transaction_processing.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import uz.uzumtech.transaction_processing.dto.WebhookDto;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebhookServise {

    RestClient restClient;

    @NonFinal
    @Value("${spring.webhook.url}")
    String webhookUri;

    @Async
    public void sendCallback(WebhookDto webhookDto) {

        try {
            Thread.sleep(5000);

            restClient.post()
                    .uri(webhookUri)
                    .body(webhookDto)
                    .retrieve()
                    .toBodilessEntity();
            log.info("Webhook {} sent successfully to {}", webhookDto, webhookUri);
        } catch (InterruptedException e) {
            log.error("Webhook sending interrupted for ID {}. Reason: {}", webhookDto.referenceId(), e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception ex) {
            log.error("Webhook failed for ID {}. Reason: {}", webhookDto.referenceId(), ex.getMessage());
        }
    }
}
