package com.mypackage.springboot.models;

import javafx.beans.DefaultProperty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accountsdata")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "accountnumber")
    private int accountNumber;

//    @NotNull
//    @Range(min = 100, message = "Minimum amount value should be $100")
    @Column(name = "amount")
    private long amount;

    @Column(name = "accounttype")
//    @NotNull
//    @Size(max = 10, message = "Type should be max 10 characters in length")
    private String accountType;
    @Column(name = "accountdescription")
    private String accountDescription;

    public Account() {
    }

    public Account(int accountNumber, long amount, String accountType, String accountDescription) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.accountType = accountType;
        this.accountDescription = accountDescription;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }
}
