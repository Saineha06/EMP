package com.neoteric.fullstackdemo_20248._1.AccountController;

import com.neoteric.fullstackdemo_20248._1.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_20248._1.model.Account;
import com.neoteric.fullstackdemo_20248._1.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")

public class AccountController {
    @PostMapping(value ="/createAccount",
               produces="application/json",
               consumes="application/json")
    public Account getAccountNumber(@RequestBody Account account)throws Exception{
        AccountService service=new AccountService();
        String accountNumber=service.createAccount(account);
        account.setAccountNumber(accountNumber);
        return account;
    }

    @PostMapping(value ="api/createAccountfromUI",
            produces="application/json",
            consumes="application/json")
    public Account getAccountNumberFromUI(@RequestBody Account account)throws Exception{
        AccountService service=new AccountService();
        String accountNumber=service.createAccountUsingHibernateFromUI(account);
        account.setAccountNumber(accountNumber);
        return account;
    }
    @GetMapping(value = "api/searchAccountUsingUI",consumes = "application/json"
            ,produces = "application/json")
    public Account  getAccountNumberUsingHibernatUI(@RequestHeader ("accountNumberFromUI")
                                                    String account_number)
            throws AccountCreationFailedException   {


        AccountService accountService = new AccountService();

        Account account=accountService.searchAccountUsingHibernateHeaders1(account_number);

        return account;

    }

}
