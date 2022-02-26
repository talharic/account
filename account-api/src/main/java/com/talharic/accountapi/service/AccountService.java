package com.talharic.accountapi.service;

import com.talharic.accountapi.dto.AccountDto;
import com.talharic.accountapi.dto.CreateAccountRequest;
import com.talharic.accountapi.dto.converter.AccountDtoConverter;
import com.talharic.accountapi.model.Account;
import com.talharic.accountapi.model.Customer;
import com.talharic.accountapi.model.Transaction;
import com.talharic.accountapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

}
