package com.neoteric.fullstackdemo_20248._1.exception;

public class AccountCreationFailedException extends Exception{
public String message;
public AccountCreationFailedException(String msg){
    this.message=msg;
}
}
