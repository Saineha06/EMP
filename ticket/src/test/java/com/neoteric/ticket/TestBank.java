package com.neoteric.ticket;

import com.neoteric.ticket.bank.model.BankForm;
import com.neoteric.ticket.bank.model.PassBook;
import com.neoteric.ticket.bank.service.BankServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBank {

    @Test

    public void bankTest(){

        BankForm bankForm=new BankForm();

        bankForm.firstName="SAINEHA";
        bankForm.lastName="Marru";
        bankForm.money=50000;
        bankForm.phoneNumber=1222222;
        bankForm.dateOfBirth="06/08/2003";
        bankForm.aadhaarNumber="123 456 123";
        bankForm.panNumber="EC123345";
        bankForm.accountType="Credit";
        bankForm.money=50000;

        BankServices bankServices=new BankServices();
       PassBook passBook= bankServices.CreateAccount(bankForm);
        Assertions.assertNotNull(passBook);


    }
}
