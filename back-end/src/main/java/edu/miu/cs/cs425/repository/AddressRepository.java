package edu.miu.cs.cs425.repository;

import java.util.List;

import edu.miu.cs.cs425.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a  WHERE a.user.userId = :userId")
    List<Address> getUserAddressList(@Param("userId") Integer userId);


}