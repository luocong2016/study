package com.example.demo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountService.findAccount(id);
    }

    @PutMapping("/{id}")
    public String updateAccount(@PathVariable int id, String name, double money) {
        return accountService.update(name, money, id) == 1 ? "success" : "fail";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {
        return accountService.delete(id) == 1 ? "success" : "fail";
    }

    @PostMapping("")
    public String addAccount(String name, double money) {
        return accountService.add(name, money) == 1 ? "success" : "fail";
    }
}
