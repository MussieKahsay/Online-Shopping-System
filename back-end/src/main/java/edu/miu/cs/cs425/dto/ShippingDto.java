package edu.miu.cs.cs425.dto;

import lombok.Data;

@Data
public class ShippingDto {

    private String address;

    private String city;

    private String state;

    private String postalCode;
}
