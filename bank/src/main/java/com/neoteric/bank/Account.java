package com.neoteric.bank;

public class Account {

    public String Name;


    public String phonenumber;


    public String ifcsCode;


    public String Branch ;

    public int balance;

    @Override
    public String toString() {
        return "Account{" +
                "Name='" + Name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", ifcsCode='" + ifcsCode + '\'' +
                ", Branch='" + Branch + '\'' +
                ", balance=" + balance +
                '}';
    }
}


