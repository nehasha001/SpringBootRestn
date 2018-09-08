package com.mypackage.springboot.Controller;

import com.mypackage.springboot.errorshandler.ErrorHandler;
import com.mypackage.springboot.models.Account;
import com.mypackage.springboot.services.AccountJDBCService;
import com.mypackage.springboot.services.AccountsService;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebInitParam;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    AccountsService accountsService;
    @Autowired
    AccountJDBCService accountJDBCService;

    @RequestMapping(value = "/")
    public String welcome() {
        return "Welcome to Spring Boot";

    }
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts() throws Exception {

//        if (1 == 1){
//            throw new Exception("Inside get all accounts exception happened");
//        }

        return accountJDBCService.getAllAccounts();
//
//        return accountsService.getAllAccounts();

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


    public ResponseEntity<Account> createAccount(@Validated @ModelAttribute("account") Account account, BindingResult errors) {

        if (errors.hasErrors()) {

            return new ResponseEntity(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
        }



        return new ResponseEntity<>(accountsService.createAccount(account), HttpStatus.OK);

    }

    @PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@RequestBody Account account) {

        return accountJDBCService.createAccount(account);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ErrorHandler());
    }



    @RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account, @PathVariable int accountNumber) {

        return accountsService.updateAccount(account);
    }

    public void deleteAccount(@PathVariable int accountNumber) {

        accountsService.deleteAccount(accountNumber);
    }

    @DeleteMapping(value = "/accounts/{accountNumber}")
    public void deleteAccounts(@PathVariable int accountNumber) {

        accountJDBCService.deleteAccount(accountNumber);
    }




}
