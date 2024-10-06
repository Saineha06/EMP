package com.neoteric.fullstackdemo_20248._1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity //dtataBase
@Table(name = "account",schema = "bank")
@Data//setters & getters


public class AccountEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name ="accountnumber" )
    private String accountNumber;

    @Column(name = "pan",nullable = false)
    private String pan;

    @Column(name ="mobilenumber",nullable = false )
    private String mobileNumber;

    @Column(name ="balance",nullable = false )
    private double balance;
     //fetch in eager is to request both parent and child class
    //fetch in lazy is to load only call (get method) the only parent class hibernate doesnot fetch the child class
    //cascade is impo to get two tables

    @OneToMany(mappedBy = "accountEntity", cascade = CascadeType. PERSIST,fetch = FetchType.LAZY)//one to many parent class in the child table
    public List<AccountAddressEntity>accountAddressEntityList;

}
