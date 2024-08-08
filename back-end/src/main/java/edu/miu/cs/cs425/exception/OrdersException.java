package edu.miu.cs.cs425.exception;

public class OrdersException extends RuntimeException{

    public OrdersException() {

    }

    public OrdersException(String msg) {
        super(msg);
        System.out.println("inside the orderexception");
    }
}

