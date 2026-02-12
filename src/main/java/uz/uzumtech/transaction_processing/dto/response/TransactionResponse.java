package uz.uzumtech.transaction_processing.dto.response;

import uz.uzumtech.transaction_processing.constant.enums.Currency;
import uz.uzumtech.transaction_processing.constant.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionResponse(
        Long id,
        Long referenceId,
        TransactionStatus status,
        BigDecimal amount,
        Currency currency,
        OffsetDateTime createdAt
) {
}
