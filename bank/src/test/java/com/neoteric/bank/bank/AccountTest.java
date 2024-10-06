package com.neoteric.bank.bank;

import com.neoteric.bank.Account;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void Test(){
        Account account=new Account();
        account.Name= "SAINEHA";
        account.balance=1000;
        account.Branch="SBI";
        account.ifcsCode="SBI90012";
        account.phonenumber="9100987654";
        System.out.println(account);


    }

}
