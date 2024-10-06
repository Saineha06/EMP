package com.neoteric.ticket.bank.service;

import com.neoteric.ticket.bank.model.BankForm;
import com.neoteric.ticket.bank.model.PassBook;

public class BankServices {

    public PassBook CreateAccount(BankForm bankForm){

        PassBook passBook=null;

        if(bankForm.money>=5000){

             passBook= new PassBook();

            passBook.branch="SBI";

            passBook.phoneNumber=9207644;

            passBook.ifscCode= "SB12354";


        }


        return passBook;

    }


}
