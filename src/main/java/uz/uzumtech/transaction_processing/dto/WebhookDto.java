package uz.uzumtech.transaction_processing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.uzumtech.transaction_processing.constant.enums.Currency;
import uz.uzumtech.transaction_processing.constant.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record WebhookDto(
    Long id,
    @JsonProperty(value = "reference_id")
    Long referenceId,
    TransactionStatus status,
    BigDecimal amount,
    Currency currency,
    OffsetDateTime createdAt
) {}
