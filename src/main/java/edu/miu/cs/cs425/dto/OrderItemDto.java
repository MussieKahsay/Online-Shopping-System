package edu.miu.cs.cs425.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemDto {
    private int productId;
    private int quantity;
    private BigDecimal price;
}
