package uz.uzumtech.transaction_processing.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.uzumtech.transaction_processing.dto.request.TransactionRequest;
import uz.uzumtech.transaction_processing.dto.response.TransactionResponse;
import uz.uzumtech.transaction_processing.service.RefundService;
import uz.uzumtech.transaction_processing.service.TransactionService;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("api/v1/refunds")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RefundController {
    RefundService refundService;

    @PostMapping()
    public ResponseEntity<TransactionResponse> refund(@Valid @RequestBody TransactionRequest request) {
        TransactionResponse response = refundService.refund(request);
        return ResponseEntity.ok(response);
    }
}
