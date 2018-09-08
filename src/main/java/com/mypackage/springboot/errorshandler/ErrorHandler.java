package com.mypackage.springboot.errorshandler;

import com.mypackage.springboot.models.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Account account = (Account) o;
        if (account.getAmount() < 100) {
            errors.rejectValue("amount", "account.amount", "amount should be greater than 100");
        }

    }
}
