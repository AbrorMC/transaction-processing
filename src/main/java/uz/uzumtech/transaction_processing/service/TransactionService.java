package uz.uzumtech.transaction_processing.service;

import uz.uzumtech.transaction_processing.dto.request.TransactionRequest;
import uz.uzumtech.transaction_processing.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse transfer(TransactionRequest request);
}
