package com.sece.springboot1.Controller;


import com.sece.springboot1.dto.Account;
import com.sece.springboot1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }


    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }


    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable long id) {
        return accountService.getAccount(id);
    }


    @PutMapping("/account/{id}")
    public Account updateAccount(
            @PathVariable long id,
            @RequestBody Account account) {

        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/account/{id}")
    public String deleteAccount(@PathVariable long id) {

        accountService.deleteAccount(id);

        return "Account deleted successfully";
    }
}