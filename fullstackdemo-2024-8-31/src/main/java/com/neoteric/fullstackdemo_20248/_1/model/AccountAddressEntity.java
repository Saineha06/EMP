package com.neoteric.fullstackdemo_20248._1.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_address",schema = "bank")
public class AccountAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;

    @Column(name="status")
    private Integer status;
//hibernate is to connect to two tables
    //fetch - taking
    @ManyToOne//child
    @JoinColumn(name = "accountnumber",referencedColumnName = "accountNumber")
    private AccountEntity accountEntity;

}
