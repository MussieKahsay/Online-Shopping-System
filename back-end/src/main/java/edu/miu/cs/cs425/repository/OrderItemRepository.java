package edu.miu.cs.cs425.repository;

import edu.miu.cs.cs425.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
