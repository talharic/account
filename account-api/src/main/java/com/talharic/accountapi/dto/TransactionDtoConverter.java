package com.talharic.accountapi.dto;

import com.talharic.accountapi.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
