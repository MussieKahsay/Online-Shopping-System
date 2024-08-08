package edu.miu.cs.cs425.exception;

public class PaymentException extends RuntimeException {

    public PaymentException() {

    }
    public PaymentException(String msg) {
        super(msg);
    }
}
