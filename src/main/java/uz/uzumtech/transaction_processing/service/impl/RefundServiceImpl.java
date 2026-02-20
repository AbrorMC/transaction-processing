package uz.uzumtech.transaction_processing.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import uz.uzumtech.transaction_processing.constant.enums.TransactionStatus;
import uz.uzumtech.transaction_processing.dto.WebhookDto;
import uz.uzumtech.transaction_processing.dto.request.TransactionRequest;
import uz.uzumtech.transaction_processing.dto.response.TransactionResponse;
import uz.uzumtech.transaction_processing.service.RefundService;
import uz.uzumtech.transaction_processing.service.TransactionService;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RefundServiceImpl implements RefundService {

    WebhookServise webhookServise;

    @Override
    public TransactionResponse refund(TransactionRequest request) {

        var response = new TransactionResponse(
                1L,
                request.referenceId(),
                TransactionStatus.REFUND,
                request.amount(),
                request.currency(),
                OffsetDateTime.now()
        );

        var webhookDto = new WebhookDto(
                response.id(),
                response.referenceId(),
                TransactionStatus.REFUND,
                response.amount(),
                response.currency(),
                OffsetDateTime.now()
        );

        webhookServise.sendCallback(webhookDto);

        return response;
    }
}
