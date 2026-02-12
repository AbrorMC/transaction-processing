package uz.uzumtech.transaction_processing.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import uz.uzumtech.transaction_processing.constant.enums.Currency;
import uz.uzumtech.transaction_processing.constant.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionRequest(
        @NotNull(message = "referenceId required") Long referenceId,
        @NotNull(message = "transaction type required") TransactionType type,
        @NotNull(message = "amount is required") @Positive(message = "amount should be positive") BigDecimal amount,
        @NotNull(message = "currency required") Currency currency,
        @NotBlank(message = "senderName required") String senderName,
        @NotBlank(message = "senderToken required") String senderToken,
        @NotBlank(message = "receiverName required") String receiverName,
        @NotBlank(message = "receiverToken required") String receiverToken
) {
}
