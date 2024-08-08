package edu.miu.cs.cs425.dto;

import lombok.Data;

@Data
public class OrdersDto {
    private Integer orderId;
    private String status;
    private String orderDate;
    private Double orderAmount;
    private String paymentStatus;

}
