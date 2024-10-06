package com.neoteric.fullstackdemo_20248._1.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="address",schema = "bank")
@Data

public class AddressEntity{
    public AddressEntity(){

    }
    @Id
    @Column(name = "id")
    public Integer id;

    @Id
    @Column(name = "state")
    public String state;

    @ManyToOne
    public AccountEntity adharEntity;


}

