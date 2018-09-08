package com.mypackage.springboot.repositories;

import com.mypackage.springboot.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface AccountsRepository  extends CrudRepository<Account, Integer> {

//
//    public List<Account> accounts = Arrays.asList(
//            new Account(1234,1000,"Current","Business Account"),
//            new Account(3456, 2000, "Savings", "Personal Account"),
//            new Account(5678,3000,"Current", "Private Account"),
//            new Account(7890,4000,"Savings","Personal Account"),
//            new Account(12345, 5000, "Current", "Business Account"),
//            new Account(23456, 6000, "Savings", "Private Account")
//    );
//
//
//    public List<Account> getAllAccounts() {
//
//        return accounts;
//
//    }
//
//    public Account searchAccount(int accountNumber) {
//
//        Account account = new Account();
//
////      Using Streams//
////        return accounts.stream()
////                .filter(account1 -> account1.getAccountNumber() == accountNumber)
////                .findFirst().get();
//
//        for ( int i = 0; i < accounts.size(); i++) {
//
//            if (accounts.get(i).getAccountNumber() == accountNumber) {
//
//                account = accounts.get(i);
//            }
//        }
//        return  account;
//    }
//
//    public List<Account> getAccount(String accountType) {
//
//        return accounts.stream()
//                .filter(account -> account.getAccountType().equals(accountType))
//                .collect(Collectors.toList());
//    }
//
//    public Account createAccount() {
//        return new Account(1245, 6000, "Checkings","Personal account");
//    }

    public Account findByAccountType(String accountType);


}
