package com.mypackage.springboot.Controller;

import com.mypackage.springboot.models.Account;
import com.mypackage.springboot.services.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    AccountsService accountsService;

    @RequestMapping(value = "/")
    public String welcome() {
        return "Welcome to Spring Boot";

    }
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts() throws Exception {

//        if (1 == 1){
//            throw new Exception("Inside get all accounts exception happened");
//        }
        return accountsService.getAllAccounts();

    }
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Account getAccount(@RequestParam int accountNumber) {

        System.out.println("inside controller" + accountNumber);

        return accountsService.searchAccounts(accountNumber);

    }

    @RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.GET)
    public Account getAllAccounts(@PathVariable(value = "accountNumber") String accountNum) {

        int accountNumber = Integer.parseInt(accountNum);
        return accountsService.searchAccounts(accountNumber);

    }

//    @RequestMapping(value = "/account/{accountType}", method = RequestMethod.GET)
//    public List<Account> getAccount(@PathVariable(value = "accountType") String accountType) {
//
//        return accountsService.getAccount(accountType);
//
//    }

//
//    @RequestMapping(value = "/accounts/{accountNum}")
//    public Account getAllAccounts(@PathVariable int accountNum) {
//
//        return accountsService.searchAccounts(accountNum);
//    }

    @PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@RequestBody Account account) {
        return accountsService.createAccount(account);

    }




}
