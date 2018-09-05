package com.mypackage.springboot.services;

import com.mypackage.springboot.models.Account;
import com.mypackage.springboot.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class AccountsService {
    @Autowired
    AccountsRepository accountsRepository;

    public List<Account> getAllAccounts() {

        List<Account> list = new ArrayList<>();
        accountsRepository.findAll().forEach(new Consumer<Account>() {
            @Override
            public void accept(Account account) {
                list.add(account);
            }
        });

        return list;
    }

    public Account searchAccounts(int accountNumber) {

        return accountsRepository.findById(accountNumber).get();
    }
//    public List<Account> getAccount(String accountType) {
//
////        return accountsRepository.getAccount(accountType);
//    }

    public Account createAccount(Account account) {
        return accountsRepository.save(account);
    }
}
