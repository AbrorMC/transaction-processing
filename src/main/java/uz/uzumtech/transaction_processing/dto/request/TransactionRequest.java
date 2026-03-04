package uz.uzumtech.transaction_processing.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import uz.uzumtech.transaction_processing.constant.enums.Currency;
import uz.uzumtech.transaction_processing.constant.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionRequest(
        @NotNull(message = "referenceId required")
        @JsonProperty("reference_id")
        Long referenceId,

        @NotNull(message = "transaction type required")
        TransactionType type,

        @NotNull(message = "amount is required")
        @Positive(message = "amount should be positive") BigDecimal amount,

        @NotNull(message = "currency required")
        Currency currency,

        @NotBlank(message = "senderName required")
        @JsonProperty("sender_name")
        String senderName,

        @NotBlank(message = "senderToken required")
        @JsonProperty("sender_token")
        String senderToken,

        @NotBlank(message = "receiverName required")
        @JsonProperty("receiver_name")
        String receiverName,

        @NotBlank(message = "receiverToken required")
        @JsonProperty("receiver_token")
        String receiverToken,

        @NotBlank(message = "merchantId required")
        @JsonProperty("merchant_id")
        String merchantId
) {
}
