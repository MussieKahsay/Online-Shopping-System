package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.dto.OrdersDto;
import edu.miu.cs.cs425.exception.OrdersException;
import edu.miu.cs.cs425.model.Orders;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrdersService {
    public OrdersDto placeOrder(Integer orderId) throws OrdersException;

    public Orders updateOrders(Integer ordersid, OrdersDto orderDTo)throws OrdersException;

    public Orders getOrdersDetails(Integer orderid)throws OrdersException;

    public List<Orders> getAllUserOrder(Integer userId)throws OrdersException;

    public List<Orders> viewAllOrders()throws OrdersException;

    public List<Orders> viewAllOrderByDate(Date date)throws OrdersException;

    public void deleteOrders(Integer userId,Integer Orderid)throws OrdersException;

}
