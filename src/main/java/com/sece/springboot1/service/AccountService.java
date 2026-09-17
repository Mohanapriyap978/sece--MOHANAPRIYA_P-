package com.sece.springboot1.service;


import com.sece.springboot1.dto.Account;
import com.sece.springboot1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public Account getAccount(long id) {
        return accountRepository.findById(id)
                .orElse(null);
    }


    public Account updateAccount(long id, Account account) {

        Account existingAccount = accountRepository.findById(id)
                .orElse(null);

        if (existingAccount == null) {
            return null;
        }

        existingAccount.setName(account.getName());
        existingAccount.setPhoneNumber(account.getPhoneNumber());

        return accountRepository.save(existingAccount);
    }


    public void deleteAccount(long id) {

        accountRepository.deleteById(id);
    }
}