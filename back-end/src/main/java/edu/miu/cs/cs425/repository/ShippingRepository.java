package edu.miu.cs.cs425.repository;

import edu.miu.cs.cs425.model.ShippingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingDetails, Integer> {

}