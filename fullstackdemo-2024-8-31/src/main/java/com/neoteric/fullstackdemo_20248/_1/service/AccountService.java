package com.neoteric.fullstackdemo_20248._1.service;


import com.neoteric.fullstackdemo_20248._1.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_20248._1.model.Account;
import com.neoteric.fullstackdemo_20248._1.model.AccountAddressEntity;
import com.neoteric.fullstackdemo_20248._1.model.AccountEntity;
import com.neoteric.fullstackdemo_20248._1.model.Address;
import hibernate.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountService {

    public String createAccount(Account account){

        String accountNumber=null;
        try {
            Connection connection= DBConnection.getConnection();
            Statement stmt=connection.createStatement();
            accountNumber= UUID.randomUUID().toString();

            // insert into bank.account value('123','priya',
            // 'abc123','123456789',2000);

            String query="insert into bank.account values("+
                    "'" +accountNumber+"'" +","
                    +"'" +account.getName()+ "'" +","
                    +"'"+account.getPan()+"'"+","
                    +"'" +account.getMobileNumber()+"'" +","
                    +account.getBalance()+")";

            boolean status=  stmt.execute(query);
            if(status){
                System.out.println("Account is Created "+accountNumber);
            }else{

            }
        } catch (Exception e) {

        }
        return accountNumber;
    }
    public Account searchAccountUsingHibernateHeaders1(String accountNumber){

        SessionFactory sessionFactory= HibernateUtils.getSeesionFactory();
        Session session=sessionFactory.openSession();
        //Query<AccountEntity>query=session.createQuery("From AccountEntity a where a.account_number=account_number");
//
//        //Transaction transaction= session.beginTransaction();
//
//
//       // query.setParameter("accountNumberFromUI",accountNumber);
//        query.setParameter("accountNumberFromUI",accountNumber);

        Query query = session.createQuery("FROM AccountEntity a WHERE a.account_number = :accountNumberFromUI");

        // Set the value for the named parameter
        query.setParameter("accountNumberFromUI", accountNumber);
        AccountEntity accountEntity = (AccountEntity) query.list().get(0);

        Account account= Account.builder()
                .accountNumber(accountEntity.getAccountNumber())
                .mobileNumber(accountEntity.getMobileNumber())
                .balance(accountEntity.getBalance())
                .pan(accountEntity.getPan())
                .address(
                        Address.builder()
                                .add1(accountEntity.getAccountAddressEntityList().get(0).getAddress1())
                                .add2(accountEntity.getAccountAddressEntityList().get(0).getAddress2())
                                .city(accountEntity.getAccountAddressEntityList().get(0).getCity())
                                .state(accountEntity.getAccountAddressEntityList().get(0).getState())
                                .pincode(accountEntity.getAccountAddressEntityList().get(0).getPincode()).build()
                )
                .build();
        return account;
    }
    public String createAccountUsingHibernateFromUI(Account account){


        SessionFactory sessionFactory= HibernateUtils.getSeesionFactory();
        Session session=sessionFactory.openSession();

        Transaction transaction= session.beginTransaction();

        AccountEntity accountEntity= new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan(account.getPan());
        accountEntity.setMobileNumber(account.getMobileNumber());
        accountEntity.setBalance(account.getBalance());

        List<AccountAddressEntity> accountAddressEntityList= new ArrayList<>();

        AccountAddressEntity accountAddressEntity = new AccountAddressEntity();

        accountAddressEntity.setAddress1(account.getAddress().getAdd1());
        accountAddressEntity.setAddress2(account.getAddress().getAdd2());
        accountAddressEntity.setCity(account.getAddress().getCity());
        accountAddressEntity.setPincode(account.getAddress().getPincode());
        accountAddressEntity.setState(account.getAddress().getState());
        accountAddressEntity.setAccountEntity(accountEntity);
        accountAddressEntity.setStatus(1);
        accountAddressEntityList.add(accountAddressEntity);

        accountEntity.setAccountAddressEntityList(accountAddressEntityList);

        session.persist(accountEntity);

        transaction.commit();

        return accountEntity.getAccountNumber();
    }
    @GetMapping(value = "api/searchAccountUsingUI",consumes = "application/json"
            ,produces = "application/json")
    public Account  getAccountNumberUsingHibernatUI(@RequestHeader("accountNumberFromUI")
                                                    String account_number)
            throws AccountCreationFailedException {


        AccountService accountService = new AccountService();

        Account account=accountService.searchAccountUsingHibernateHeaders1(account_number);
        return account;

    }
}