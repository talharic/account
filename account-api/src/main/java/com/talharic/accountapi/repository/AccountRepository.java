package com.talharic.accountapi.repository;

import com.talharic.accountapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
