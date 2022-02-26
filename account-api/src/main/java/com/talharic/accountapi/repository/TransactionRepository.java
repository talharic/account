package com.talharic.accountapi.repository;

import com.talharic.accountapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
