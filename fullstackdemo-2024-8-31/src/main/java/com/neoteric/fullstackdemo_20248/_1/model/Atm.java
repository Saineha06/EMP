package com.neoteric.fullstackdemo_20248._1.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@NoArgsConstructor
public class Atm {

    private String cardNumber;

    private String pin;

    private String accountNumber;

    private String cvv;

    private Date cardExpriry;

    public Atm(String cardNumber, String pin, String accountNumber, String cvv, Date cardExpriry) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.cvv = cvv;
        this.cardExpriry = cardExpriry;
    }
}
