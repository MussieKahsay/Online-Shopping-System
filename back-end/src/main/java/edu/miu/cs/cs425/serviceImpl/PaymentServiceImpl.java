package edu.miu.cs.cs425.serviceImpl;

import edu.miu.cs.cs425.enumtype.OrderStatus;
import edu.miu.cs.cs425.enumtype.PaymentMethod;
import edu.miu.cs.cs425.enumtype.PaymentStatus;
import edu.miu.cs.cs425.exception.PaymentException;
import edu.miu.cs.cs425.exception.UserException;
import edu.miu.cs.cs425.model.Orders;
import edu.miu.cs.cs425.model.Payment;
import edu.miu.cs.cs425.model.User;
import edu.miu.cs.cs425.repository.OrderRepository;
import edu.miu.cs.cs425.repository.PaymentRepository;
import edu.miu.cs.cs425.repository.UserRepository;
import edu.miu.cs.cs425.service.PaymentService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment makePayment(Integer orderId, Integer userId) throws PaymentException {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found in the database."));

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new UserException("order not found in the database."));;
        if (order == null) {
            throw new PaymentException("Order not found for the given customer.");
        }

        Payment payment = new Payment();
        payment.setPaymentAmount(order.getTotalAmount());
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentMethod(PaymentMethod.UPI);
        payment.setPaymentStatus(PaymentStatus.SUCCESSFUL);
        payment.setUser(existingUser);

        payment.setOrder(order);
        paymentRepository.save(payment);

        order.setStatus(OrderStatus.SHIPPED);

        // Set the payment for the order
        order.setPayment(payment);
        // Save the changes to the Order entity, including the associated Payment
        orderRepository.save(order);

        existingUser.getPayments().add(payment);
        // Save the changes to the User entity, including the new payment association
        userRepository.save(existingUser);
        // Save the payment to the database
        return  payment;
    }
}
