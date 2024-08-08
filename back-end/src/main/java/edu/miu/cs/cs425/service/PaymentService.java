package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.exception.PaymentException;
import edu.miu.cs.cs425.model.Payment;

public interface PaymentService {
    Payment makePayment(Integer orderId, Integer userId) throws PaymentException;
}
