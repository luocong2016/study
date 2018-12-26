package com.example.demo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    @Transactional
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    @Transactional
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
