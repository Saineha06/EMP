package com.neoteric.fullstackdemo_20248._1.model;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Address {

    private String add1;
    private String add2;
    private String city;
    private String pincode;
    private String state;

}